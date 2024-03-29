package io.github.mfaisalkhatri.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
@Getter
public class HomePage {

    public static HomePage homePage () {
        return new HomePage ();
    }

    private final Locator logoImage = Locator.buildLocator ()
        .name ("Logo Image")
        .web (By.cssSelector ("div > a > img.large"))
        .build ();

    private final Locator accountLink = Locator.buildLocator ()
        .name ("Account link")
        .web (By.linkText ("ACCOUNT"))
        .build ();

    private final Locator RegisterLink = Locator.buildLocator ()
        .name ("Register Link")
        .web (By.linkText ("Register"))
        .build ();

    private final Locator logOutLink = Locator.buildLocator ()
        .name ("Log out link")
        .web (By.linkText ("Log Out"))
        .build ();
}
