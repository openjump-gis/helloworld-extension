package org.openjump.example;

// let's reuse one i18n instance in the whole extension
// feel free to use one per plugin
import static org.openjump.example.HelloWorldExtension.I18N;

import com.vividsolutions.jump.workbench.plugin.PlugInContext;

public class InternationalizedHelloWorldPlugin extends HelloWorldPlugin {
  // translate the message
  private static final String MESSAGE = I18N.get("hello-world-message");

  @Override
  public boolean execute(PlugInContext context) throws Exception {
    return showMessage(context, MESSAGE);
  }

  /**
   * use a translated plugin name for menu entries instead of the hardcoded one
   */
  @Override
  public String getName() {
    return I18N.get("hello-world-plugin-name");
  }
}
