package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askCarName() {
        String input = Console.readLine();
//        validateCars(input);
        return input;
    }

    public static int askPlayTime() {
        return 0;
    }
}
