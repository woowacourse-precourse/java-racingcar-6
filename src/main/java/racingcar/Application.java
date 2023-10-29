package racingcar;

import java.util.List;
import racingcar.domain.CarMovement;
import racingcar.domain.ResultOutput;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        CarMovement carMovement = new CarMovement();
        ResultOutput resultOutput = new ResultOutput();

        String[] carNames = userInput.getCarNames();
        int tryNumber = userInput.getTryNumber();

        List<Boolean> carMoveResult = carMovement.getCarMoveResult(carNames.length);


    }
}
