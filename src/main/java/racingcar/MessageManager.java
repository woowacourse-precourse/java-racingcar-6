package racingcar;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
    private static final ResourceBundle exceptionMessages = ResourceBundle.getBundle("exception-messages");

    public static void getInputCarNameMessage() {
        System.out.println(messages.getString("inputCarName.message"));
    }

    public static void getInputNumberOfAttemptsMessage() {
        System.out.println(messages.getString("inputNumberOfAttempts.message"));
    }

    public static void getRaceResultMessage() {
        System.out.println(messages.getString("raceResultMessage.message"));
    }

    public static String getCommaSeparatorMissingMessage() {
        return exceptionMessages.getString("commaSeparatorMissing.message");
    }

    public static String getStringTooLongMessage() {
        return exceptionMessages.getString("stringTooLong.message");
    }

    public static String  getContainsCommaAndBlankMessage() {
        return exceptionMessages.getString("containsCommaAndBlank.message");
    }

    public static String getNonPositiveNumberMessage() {
        return exceptionMessages.getString("nonPositiveNumber.message");
    }
}
