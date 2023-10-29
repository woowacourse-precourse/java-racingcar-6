package racingcar;

import java.util.HashMap;

public class RacingGame {
    public void startGame() {
        HashMap<String, Integer> carName = new HashMap<>();
        InputCarName inputCarName = new InputCarName();
        carName = inputCarName.inputCarName();
        System.out.println(carName);

        InputMovement inputMovement = new InputMovement();
        int movement = inputMovement.inputMovement();
        System.out.println(movement);
    }
}
