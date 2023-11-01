package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constants.ViewMessages.REQUEST_CAR_NAMES;
import static racingcar.constants.ViewMessages.REQUEST_RACE_ROUNDS;

public class InputView{


    public static String getUserInput() {
        return Console.readLine();
    }

    public static String getCarNames() {
        System.out.println((REQUEST_CAR_NAMES.getMessage()));
        return getUserInput();
    }

    public static String getRounds() {
        System.out.println((REQUEST_RACE_ROUNDS.getMessage()));
        return getUserInput();
    }

}
