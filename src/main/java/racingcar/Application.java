package racingcar;

import java.util.List;
import racingcar.domain.CarMovement;
import racingcar.domain.ResultOutput;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        CarMovement carMovement = new CarMovement();
        ResultOutput resultOutput = new ResultOutput();
        UserInput userInput = new UserInput();

        String[] carNames = userInput.inputCarNames();
        int tryNumber = userInput.inputTryNumber();
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            List<Boolean> boolResult = carMovement.getBoolResult(carNames.length);
            resultOutput.printRacingResult(carNames, boolResult);
        }

        resultOutput.printWinner();


    }
}
