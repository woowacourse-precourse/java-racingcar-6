package racingcar;

import racingcar.utils.InputValidator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();

        String userInputCarsName = inputView.askCarsName();
        System.out.println(userInputCarsName);
        String preprocessedInputString = inputValidator.preprocessInputString(userInputCarsName);
        System.out.println(preprocessedInputString);
    }
}
