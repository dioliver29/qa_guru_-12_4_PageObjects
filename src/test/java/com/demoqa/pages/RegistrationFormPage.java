package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();


    // locators
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChoice =  $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectChoice = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            selectPicture = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            listOfStates = $(byText("Select State")),
            listOfCities = $(byText("Select City"));

    // actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationFormPage setGender(String userGender) {
        genderChoice.$(byText(userGender)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectChoice.click();
        subjectChoice.setValue("m");
        $(byText(subject)).click();
        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        hobbiesSelect.$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage setPicture() {
        selectPicture.uploadFromClasspath("file.png");
        return this;
    }

    public RegistrationFormPage setAddress(String userAddress) {
        userAddressInput.setValue(userAddress);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        listOfStates.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        listOfCities.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPage checkResult(String registrationFormText, String registrationFormValue) {
        $(".table-responsive").$(byText(registrationFormText))
                .parent().shouldHave(text(registrationFormValue));
        return this;
    }
}
