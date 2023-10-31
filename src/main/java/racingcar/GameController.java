package racingcar;

import java.util.HashMap;

public class GameController {
    private String carName = "";
    private HashMap<String, Integer> cars;
    public InputDataHandler inputDataHandler = new InputDataHandler();
    public NumberGenerator numberGenerator = new NumberGenerator();

    public String getCarName(int index) {
        carName = inputDataHandler.findCarName(index);
        return carName;
    }

    public int getCarMoveForward(String carName) {
        return inputDataHandler.findCarMovement(carName);
    }

    public int getRandomNumber() {
        return numberGenerator.createRandomNumber();
    }

}
