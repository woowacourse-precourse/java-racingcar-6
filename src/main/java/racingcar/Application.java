package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarMovement;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        CarMovement carMovement = new CarMovement();

        List<Object> racingData = userInput.inputRacingData();
        int[] moveResults = carMovement.getCarMoveCount(racingData);
        System.out.println(Arrays.toString(moveResults));


    }
}
