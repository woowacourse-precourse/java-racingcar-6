package racingcar;

import java.util.List;
import racingcar.domain.CarMovement;
import racingcar.domain.InputCheck;
import racingcar.domain.ResultOutput;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        CarMovement carMovement = new CarMovement();
        UserInput userInput = new UserInput();

        String carNames = userInput.inputCarNames();
        String tryNumber = userInput.inputTryNumber();
        Object[] passedInputData = InputCheck.checkUserInput(carNames, tryNumber);

        String[] passedCarNames = (String[]) passedInputData[0];
        int passedTryNumber = (int) passedInputData[1];

        System.out.println("실행 결과");
        for (int i = 0; i < passedTryNumber; i++) {
            List<String> stringResult = carMovement.getStringResult(passedCarNames.length);
            ResultOutput.printRacingResult(passedCarNames, stringResult);
        }

        ResultOutput.printWinner();


    }
}
