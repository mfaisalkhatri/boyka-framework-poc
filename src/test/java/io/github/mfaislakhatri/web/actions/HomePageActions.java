package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static io.github.mfaislakhatri.web.pages.HomePage.homePage;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class HomePageActions {

    public static String getAltTextOfLogo () {
        return withMouse (homePage ().getLogoImage ()).getAttribute ("alt");
    }

    public static void openWebsite (String websiteLink) {
        navigate ().to (websiteLink);
    }

    public CreateAccountPageActions navigateToCreateAccountPage() {
        withMouse (homePage ().getAccountLink ()).click ();
        withMouse (homePage ().getRegisterLink ()).click ();
        return new CreateAccountPageActions();
    }

}
