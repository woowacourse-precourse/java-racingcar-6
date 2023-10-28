package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void startGame() {
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());
        String userInput = InputManager.getCarNamesFromPlayerInput();
        List<Car> cars = racingGameManager.createCarListFromPlayerInput(userInput);

        String countInput = InputManager.getCountFromPlayerInput();
        racingGameManager.createCountFromPlayerInput(countInput);
    }
}
