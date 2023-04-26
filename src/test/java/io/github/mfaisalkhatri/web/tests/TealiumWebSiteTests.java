package io.github.mfaisalkhatri.web.tests;

import static io.github.mfaisalkhatri.web.actions.CreateAccountPageActions.registerUser;
import static io.github.mfaisalkhatri.web.actions.HomePageActions.getAltTextOfLogo;
import static io.github.mfaisalkhatri.web.actions.HomePageActions.openWebsite;
import static io.github.mfaisalkhatri.web.actions.MyDashboardPageActions.getRegisteredMessageText;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class TealiumWebSiteTests extends BaseTest {

    @BeforeClass
    public void setup () {
        openWebsite ("https://ecommerce.tealiumdemo.com/");
    }

    @Test
    public void testTealiumHomepage () {
        assertEquals (getAltTextOfLogo (), "TealiumEcommerce Demo");
    }

    @Test
    public void testRegisterUser () {
        registerUser ();
        assertEquals (getRegisteredMessageText (), "Thank you for registering with Tealium Ecommerce.");
    }
}
