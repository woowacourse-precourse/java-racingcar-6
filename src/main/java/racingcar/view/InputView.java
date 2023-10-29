package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }


    public String inputCarName() {
        return Console.readLine();
    }

    public String inputGameRound() {
        return Console.readLine();
    }
}
