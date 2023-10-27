package racingcar;

import racingcar.utils.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();

        String userInputCarsName = inputView.askCarsName();
        System.out.println(userInputCarsName);
        String preprocessedInputString = inputValidator.preprocessInputString(userInputCarsName);
        System.out.println(preprocessedInputString);

        List<String> inputStringList = inputValidator.validateCarsNameInput(preprocessedInputString);
        for (String inputString : inputStringList) {
            System.out.println("inputString = " + inputString);
        }
    }
}
