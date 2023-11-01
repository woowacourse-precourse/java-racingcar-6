package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNamesFromPlayerInput() {
        OutputView.printInputCarName();
        return Console.readLine();
    }

    public static String getRaceCountFromPlayerInput() {
        OutputView.printInputRaceCount();
        return Console.readLine();
    }
}
