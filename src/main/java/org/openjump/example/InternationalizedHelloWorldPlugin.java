package org.openjump.example;

// let's reuse one i18n instance in the whole extension
// feel free to use one per plugin
import static org.openjump.example.HelloWorldExtension.i18n;

import com.vividsolutions.jump.workbench.plugin.PlugInContext;

public class InternationalizedHelloWorldPlugin extends HelloWorldPlugin {

  @Override
  public boolean execute(PlugInContext context) throws Exception {
    return showMessage(context, i18n("hello-world-message") );
  }

  /**
   * use a translated plugin name for menu entries instead of the hardcoded one
   */
  @Override
  public String getName() {
    return i18n("hello-world-plugin-name");
  }
}
