package org.openjump.example;

import com.vividsolutions.jump.I18N;
import com.vividsolutions.jump.workbench.plugin.Extension;
import com.vividsolutions.jump.workbench.plugin.PlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;

public class HelloWorldExtension extends Extension {

  @Override
  public void configure(PlugInContext context) throws Exception {
    PlugIn p = new HelloWorldPlugin();
    // convention binds us to initialize() a plugin before doing anything else with it
    p.initialize(context);
    // installing menu item is done in initialize() above, but it may happen here as well
    
    new InternationalizedHelloWorldPlugin().initialize(context);
  }

  public static String i18n( String key, Object... objects ) {
    return I18N.getInstance("org.openjump.example").get(key, objects);
  }

  /**
   * Just an example method used for the example testing
   * @return true
   */
  public static boolean returnTrue() {
    return true;
  }

}
