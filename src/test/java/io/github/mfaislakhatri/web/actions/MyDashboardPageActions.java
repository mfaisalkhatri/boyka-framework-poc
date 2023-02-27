package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static io.github.mfaislakhatri.web.pages.MyDashboardPage.myDashboardPage;

import lombok.Getter;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class MyDashboardPageActions {
    public static MyDashboardPageActions myDashBoardPageActions () {
        return new MyDashboardPageActions ();
    }
    public static String getRegisteredMessageText () {
        return onElement (myDashboardPage ().getSuccessfulRegistrationMsg ()).getText ();
    }

}
