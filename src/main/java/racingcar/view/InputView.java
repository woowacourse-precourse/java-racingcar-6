package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.PrintMessage;
import racingcar.utils.InputException;

import java.util.List;

public class InputView {
    public static String inputCarName() {
        String carNames = printAndInput(PrintMessage.INPUT_RACING_CAR_NAME);
        InputException.isContainComma(carNames);
        return carNames;
    }

    public static String printAndInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
