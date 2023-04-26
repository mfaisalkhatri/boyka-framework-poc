package io.github.mfaisalkhatri.web.tests;

import static com.github.wasiqb.boyka.manager.DriverManager.closeDriver;
import static com.github.wasiqb.boyka.manager.DriverManager.createDriver;

import com.github.wasiqb.boyka.enums.PlatformType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class BaseTest {

    @Parameters ({ "platformType", "configKey" })
    @BeforeTest
    public void setupTest (PlatformType platformType, String configKey) {
        createDriver (platformType, configKey);

    }

    @AfterTest
    public void tearDown () {
        closeDriver ();
    }
}
