package io.github.mfaisalkhatri.web.actions;

import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static io.github.mfaisalkhatri.web.pages.MyDashboardPage.myDashboardPage;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class MyDashboardPageActions {

    public static String getRegisteredMessageText () {
        return onElement (myDashboardPage ().getSuccessfulRegistrationMsg ()).getText ();
    }

}
