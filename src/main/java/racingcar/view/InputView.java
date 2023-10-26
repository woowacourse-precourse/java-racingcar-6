package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] inputCarName() {
        OutputView.printInputCarName();
        String input = Console.readLine();
        return input.split(",");
    }
}
