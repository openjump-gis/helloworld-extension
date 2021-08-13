package org.openjump.example;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.vividsolutions.jump.workbench.WorkbenchContext;
import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.EnableCheck;
import com.vividsolutions.jump.workbench.plugin.EnableCheckFactory;
import com.vividsolutions.jump.workbench.plugin.MultiEnableCheck;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.MenuNames;

public class HelloWorldPlugin extends AbstractPlugIn {

  private static final Icon ICON = new ImageIcon("attention.png");
  private static final String MESSAGE = "Hello World!";
  private WorkbenchContext workbenchContext;

  @Override
  public void initialize(PlugInContext context) throws Exception {
    // always provide parent AbstractPlugin with the context as well
    super.initialize(context);
    // save workbenchcontext for later use
    this.workbenchContext = context.getWorkbenchContext();

    context.getFeatureInstaller().addMainMenuPlugin(this, new String[] { MenuNames.PLUGINS, "Example" });
  }

  @Override
  public boolean execute(PlugInContext context) throws Exception {
    return showMessage(context, MESSAGE);
  }

  protected boolean showMessage(PlugInContext context, String message) throws Exception {
    context.getWorkbenchFrame().getOutputFrame().createNewDocument();
    context.getWorkbenchFrame().getOutputFrame().addText(message);
    context.getWorkbenchFrame().getOutputFrame().surface();

    return true;
  }
  
  /**
   * return a (Multi)Enablecheck here if executing the plugin needs preconditions
   * to be met. for demonstrations purposes we add the following conditions
   * - a Task Window must exist and be selected/activated
   * - there must exist at least one Layerable in the Task Window
   * 
   * return EnableCheck
   */
  @Override
  public EnableCheck getEnableCheck() {
    EnableCheckFactory checkFactory = EnableCheckFactory.getInstance(workbenchContext);

    // these are not actually needed but added for demonstration only
    // hover with the mouse over the menu item if it is disabled
    // to receive a text message explaining the reason why
    return new MultiEnableCheck().add(checkFactory.createWindowWithLayerNamePanelMustBeActiveCheck())
        .add(checkFactory.createAtLeastNLayerablesMustExistCheck(1));
  }

  /**
   * return a name used in menus etc.
   */
  @Override
  public String getName() {
    return "HelloWorld!";
  }

  /**
   * return an icon used in menus. 16x16 pixels is the default size expected see
   * {@link Iconified} for additional methods you may provide
   */
  @Override
  public Icon getIcon() {
    return ICON;
  }
}
