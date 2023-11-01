package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;

public class InputView {

    public static String inputCarName() {
        System.out.println(Constants.START_MESSAGE);
        return Console.readLine();
    }

    public static String inputNumOfRounds() {
        System.out.println(Constants.REQUEST_NUMBER_OF_ROUNDS);
        return Console.readLine();
    }
}
