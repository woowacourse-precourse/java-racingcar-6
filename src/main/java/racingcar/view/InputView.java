package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] inputCarList() {
        String input = Console.readLine();
        return input.split(",");
    }

    public static String inputGameRound() {
        String input = Console.readLine();
        return input;
    }

}
