package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCarName() {
        return validateCarName(Console.readLine());
    }


    public static String readTryNumber() {
        return Console.readLine();
    }

    private static String validateCarName(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
        return input;
    }


}
