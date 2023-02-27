package io.github.mfaislakhatri.web.tests;

import static com.github.wasiqb.boyka.manager.DriverManager.closeDriver;
import static com.github.wasiqb.boyka.manager.DriverManager.createDriver;
import static io.github.mfaislakhatri.web.pages.HomePage.getAltTextOfLogo;
import static io.github.mfaislakhatri.web.pages.HomePage.openWebsite;
import static org.testng.Assert.assertEquals;

import com.github.wasiqb.boyka.enums.PlatformType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class TealiumWebSiteTests {

    @Parameters ({ "platformType", "configKey" })
    @BeforeTest
    public void setupTest (PlatformType platformType, String configKey) {
        createDriver (platformType, configKey);

    }

    @Test
    public void testTealiumHomepage () {
        openWebsite ("https://ecommerce.tealiumdemo.com/");
        assertEquals (getAltTextOfLogo (), "TealiumEcommerce Demo");

    }

    @AfterTest
    public void tearDown () {
        closeDriver ();
    }
}
