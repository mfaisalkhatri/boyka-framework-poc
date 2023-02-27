package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static io.github.mfaislakhatri.web.pages.HomePage.homePage;

import lombok.Getter;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
@Getter
public class HomePageActions {

    public static String getAltTextOfLogo () {
        return withMouse (homePage ().getLogoImage ()).getAttribute ("alt");
    }

    public static void openWebsite (String websiteLink) {
        navigate ().to (websiteLink);
    }

    public static void navigateToCreateAccountPage () {
        withMouse (homePage ().getAccountLink ()).click ();
        withMouse (homePage ().getRegisterLink ()).click ();
    }

    public static boolean isLogoutLinkDisplayed () {
        withMouse (homePage ().getAccountLink ()).click ();
        return onElement (homePage ().getLogOutLink ()).isDisplayed ();
    }
}
