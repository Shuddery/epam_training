package utils;

import java.time.LocalDate;
import java.util.Map;

public interface IConstants {
    String errorMessage = "Login or Password is incorrect";
    String redBorder = "rgb(244, 67, 54)";
    String linkToSupport = "mailto:support@mis.ru";
    String blueBackground = "rgba(207, 228, 255, 1)";
    String cyanBlueBackground = "rgba(37, 132, 254, 1)";
    String blueBackgroundColorInNavigatorTree = "rgba(37, 132, 254, 0.08)";
    String blueBackgroundForBorder = "rgb(37, 132, 254)";
    String prefix = "[AQA] ";
    String footer = "ⓒ " + LocalDate.now().getYear() + " EPAM Systems, Inc. All Rights Reserved.";
    String emfForms = "EMF Forms";
    String greyHover = "rgba(0, 0, 0, 0.04)";
    String emfOptionsHighlighted = "rgba(217, 219, 227, 1)";
    String userSessionKey = "userSession";
    String layout = "{\"lg\": {\"h\": 1, \"w\": 12, \"x\": 0, \"y\": 0, \"moved\": false, \"static\": false}, \"isMultiline\": false}";
    String fillRequiredFieldMessageENG = "Please fill in the required field";
    String fillRequiredFieldMessage = " is a required field";
    String selectValueMessage = "Please select a value";
    String greyFlagButton = "rgba(149, 151, 164, 1)";
    String redFlagButton = "rgba(244, 67, 54, 1)";
    String validPathMessage = "Please provide a valid path";
    String greySelectedSection = "rgba(234, 235, 239, 1)";
    String pathResourceType = "resourceType";
    String sectionGroupAlreadyExistErrorMessage = "Section group with this title already exists";
    String inputSize = "(102, 36)";
    String whiteBackground = "rgba(0, 0, 0, 0)";
}