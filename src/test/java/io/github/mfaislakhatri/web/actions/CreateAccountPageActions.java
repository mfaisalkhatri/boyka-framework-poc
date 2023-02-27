package io.github.mfaislakhatri.web.actions;

import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static io.github.mfaislakhatri.web.actions.HomePageActions.homePageActions;
import static io.github.mfaislakhatri.web.pages.CreateAccountPage.createAccountPage;

import lombok.Getter;
import net.datafaker.Faker;

/**
 * @author Faisal Khatri
 * @since 2/27/2023
 **/
public class CreateAccountPageActions {

    public static CreateAccountPageActions createAccountPageActions () {
        return new CreateAccountPageActions ();
    }
    public static void registerUser () {
        homePageActions ().navigateToCreateAccountPage ();

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

        withMouse (createAccountPage ().getRegisterBtn ()).click ();
    }

}
