package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.constant.Message;
import racingcar.exception.IllegalArgumentMessage;
import racingcar.exception.IllegalArgumentMessageException;

public class InputView {
    private static final int FIVE_LENGTH = 5;
    private static final String NEGATIVE = "-";
    private static final String DELIMITER = ",";

    public static String getTryCountFromUser() {
        System.out.println(Message.ASK_TRY_COUNT.getMessage());
        return Console.readLine();
    }

    public static int validateTryCount(String tryCountFromUser) {
        if (isNull(tryCountFromUser)) {
            throw new IllegalArgumentMessageException(IllegalArgumentMessage.NOT_NULL);
        }
        if (isNegative(tryCountFromUser)) {
            throw new IllegalArgumentMessageException(IllegalArgumentMessage.ONLY_POSITIVE);
        }
        if (!isNumber(tryCountFromUser)) {
            throw new IllegalArgumentMessageException(IllegalArgumentMessage.ONLY_DIGIT);
        }

        return Integer.parseInt(tryCountFromUser);
    }

    public static String getNamesFromUser() {
        System.out.println(Message.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String[] validateNames(String namesFromUser) {
        if (isNull(namesFromUser)) {
            throw new IllegalArgumentMessageException(IllegalArgumentMessage.NOT_NULL);
        }
        String[] splitNames = splitWithComma(namesFromUser);
        if (Arrays.stream(splitNames).anyMatch(InputView::isInvalidLength)) {
            throw new IllegalArgumentMessageException(IllegalArgumentMessage.UNDER_5_LENGTH_OR_NON_EMPTY);
        }

        return splitNames;
    }

    private static boolean isNull(String stringFromUser) {
        return stringFromUser == null;
    }

    private static boolean isNegative(String stringFromUser) {
        return stringFromUser.contains(NEGATIVE);
    }

    private static boolean isNumber(String stringFromUser) {
        try {
            int number = Integer.parseInt(stringFromUser);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static String[] splitWithComma(String stringFromUser) {
        return stringFromUser.split(DELIMITER);
    }

    private static boolean isInvalidLength(String name) {
        return isOver5Length(name) || isEmpty(name);
    }

    private static boolean isOver5Length(String name) {
        return name.length() > FIVE_LENGTH;
    }

    private static boolean isEmpty(String name) {
        return name.isEmpty();
    }
}