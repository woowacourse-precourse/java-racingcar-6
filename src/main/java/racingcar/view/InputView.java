package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] inputCarList() {
        String input = Console.readLine();
        return splitInput(input);
    }

    public static String inputGameRound() {
        return Console.readLine();
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

}
