package io.github.mfaislakhatri.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class MyDashboardPage {

    private final Locator successfulRegistrationMsg = Locator.buildLocator ()
        .name ("Successful Registration Text")
        .web (By.cssSelector (".messages span"))
        .build ();

    private final Locator registeredNameText = Locator.buildLocator ()
        .name ("Registered Name Text")
        .web (By.cssSelector (".welcome-msg p strong"))
        .build ();
}
