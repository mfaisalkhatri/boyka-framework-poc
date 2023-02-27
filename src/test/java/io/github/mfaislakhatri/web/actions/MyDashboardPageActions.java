package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static io.github.mfaislakhatri.web.pages.MyDashboardPage.myDashboardPage;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class MyDashboardPageActions {

    public static String getRegisteredMessageText () {
        return onElement (myDashboardPage ().getSuccessfulRegistrationMsg ()).getText ();
    }

}
