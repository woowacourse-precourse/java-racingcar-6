package racingcar.view;

import static racingcar.constant.PrintMessage.INPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.constant.PrintMessage.INPUT_RACING_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println(INPUT_RACING_CAR_NAME);
        return Console.readLine();
    }

    public String readNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        return Console.readLine();
    }

}
