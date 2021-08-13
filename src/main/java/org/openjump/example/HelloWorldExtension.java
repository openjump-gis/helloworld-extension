package org.openjump.example;

import com.vividsolutions.jump.I18N;
import com.vividsolutions.jump.workbench.plugin.Extension;
import com.vividsolutions.jump.workbench.plugin.PlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;

public class HelloWorldExtension extends Extension {

  public static I18N I18N = com.vividsolutions.jump.I18N.getInstance("org.openjump.example");

  @Override
  public void configure(PlugInContext context) throws Exception {
    PlugIn p = new HelloWorldPlugin();
    // convention binds us to initialize() a plugin before doing anything else with it
    p.initialize(context);
    // installing menu item is done in initialize() above, but it may happen here as well
    
    new InternationalizedHelloWorldPlugin().initialize(context);
  }

}
