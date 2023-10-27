package racingcar.model;

import java.util.ArrayList;
import racingcar.view.ConsoleInputView;

public class Input {
    public static void inputCarNames(Race race) {
        String inputList = ConsoleInputView.UserInput();
        String[] inputArr = inputList.split(",");
        ArrayList<String> carNames = CarValidation.validateAll(inputArr);
        race.initialize(carNames);
    }

    public static int inputTryNumber() {
        String inputNumber = ConsoleInputView.UserInput();
        int tryNumber = Integer.parseInt(inputNumber);
        if (tryNumber < Constants.MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("잘못된 시도 횟수입니다.");
        }
        return tryNumber;
    }

}
