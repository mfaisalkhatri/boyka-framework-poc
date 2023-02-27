package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.drivers.DriverActions.withDriver;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static io.github.mfaislakhatri.web.actions.HomePageActions.navigateToCreateAccountPage;
import static io.github.mfaislakhatri.web.pages.CreateAccountPage.createAccountPage;

import com.github.wasiqb.boyka.actions.elements.ElementFinder;
import com.github.wasiqb.boyka.enums.WaitStrategy;
import net.datafaker.Faker;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class CreateAccountPageActions {

    public static void registerUser () {
        navigateToCreateAccountPage ();

        Faker faker = new Faker ();
        onTextBox (createAccountPage ().getFirstNameField ()).enterText (faker.name ()
            .firstName ());
        onTextBox (createAccountPage ().getMiddleNameField ()).enterText (faker.name ()
            .firstName ());
        onTextBox (createAccountPage ().getLastNameField ()).enterText (faker.name ()
            .lastName ());
        onTextBox (createAccountPage ().getEmailAddressField ()).enterText (faker.internet ()
            .emailAddress ());

        String password = faker.internet ()
            .password ();
        onTextBox (createAccountPage ().getPasswordField ()).enterText (password);
        onTextBox (createAccountPage ().getConfirmPasswordField ()).enterText (password);

        //withMouse (createAccountPage ().getRegisterBtn ()).dragTo (createAccountPage ().getRegisterBtn ());
//        withDriver ().executeScript ("arguments[0].scrollIntoView(true);",
//            ElementFinder.find (createAccountPage ().getRegisterBtn (), WaitStrategy.CLICKABLE));
        withMouse (createAccountPage ().getRegisterBtn ()).click ();
    }

}
