package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class InputView {
    private static final int ONE_LENGTH = 1;

    public static String getTryCountFromUser() {
        System.out.println(Message.ASK_TRY_COUNT);
        return Console.readLine();
    }

    public static int validateTryCount(String tryCountFromUser) {
        if (!isNotNull(tryCountFromUser)) {
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

    private static boolean isNotNull(String stringFromUser) {
        return stringFromUser != null;
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
}