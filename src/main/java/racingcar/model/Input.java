package racingcar.model;

import java.util.ArrayList;
import racingcar.view.ConsoleInputView;

public class Input {
    public void inputCarNames(Race race) {
        String inputList = ConsoleInputView.UserInput();
        String[] inputArr = inputList.split(",");
        ArrayList<String> carNames = CarValidation.validateAll(inputArr);
        race.initialize(carNames);
    }

    public int inputTryNumber() {
        String inputNumber = ConsoleInputView.UserInput();
        try {
            int tryNumber = Integer.parseInt(inputNumber);

            if (tryNumber < Constants.MIN_TRY_NUMBER) {
                throw new IllegalArgumentException("잘못된 시도 횟수입니다.");
            }
            return tryNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }

}
