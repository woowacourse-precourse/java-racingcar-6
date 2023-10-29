package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.constant.Message;
import racingcar.exception.IllegalArgumentMessage;
import racingcar.exception.IllegalArgumentMessageException;

public class InputView {
    private static final int ONE_LENGTH = 1;
    private static final int FIVE_LENGTH = 5;

    public static String getTryCountFromUser() {
        System.out.println(Message.ASK_TRY_COUNT);
        return Console.readLine();
    }

    public static int validateTryCount(String tryCountFromUser) {
        if (isNull(tryCountFromUser)) {
            throw new IllegalArgumentException();
        }
        if (!isOneLength(tryCountFromUser)) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(tryCountFromUser)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(tryCountFromUser);
    }

    public static String getNamesFromUser() {
        System.out.println(Message.INPUT_CAR_NAMES);
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

    private static boolean isOneLength(String stringFromUser) {
        return stringFromUser.length() == ONE_LENGTH;
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
        return stringFromUser.split(",");
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