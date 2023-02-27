package io.github.mfaislakhatri.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
@Getter
public class CreateAccountPage {

    private final Locator firstNameField = Locator.buildLocator ()
        .name ("First Name")
        .web (By.id ("firstname"))
        .build ();

    private final Locator middleNameField = Locator.buildLocator ()
        .name ("Middle Name")
        .web (By.id ("middlename"))
        .build ();

    private final Locator lastNameField = Locator.buildLocator ()
        .name ("Last Name")
        .web (By.id ("lastname"))
        .build ();

    private final Locator emailAddressField    = Locator.buildLocator ()
        .name ("Email Address")
        .web (By.id ("email_address"))
        .build ();
    private final Locator passwordField        = Locator.buildLocator ()
        .name ("Password")
        .web (By.id ("password"))
        .build ();
    private final Locator confirmPasswordField = Locator.buildLocator ()
        .name ("Confirm Password")
        .web (By.id ("confirmation"))
        .build ();

    private final Locator registerBtn = Locator.buildLocator ()
        .name ("Register Button")
        .web (By.cssSelector ("div.buttons-set > button"))
        .build ();

    public static CreateAccountPage createAccountPage () {
        return new CreateAccountPage ();
    }

}
