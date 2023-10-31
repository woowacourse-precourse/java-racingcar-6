package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class GameSetting {

    public InputDataHandler inputDataHandler = new InputDataHandler();
    private HashMap<String, Integer> cars;
    private String[] carNames;
    private ArrayList<Car> carArray = new ArrayList<>();
    private int attemptNumber;

    public ArrayList<Car> createCarName() {
        carNames = inputDataHandler.getStringFromPlayer();
        for (String carName : carNames) {
            carArray.add(new Car(carName));
        }
        return carArray;
    }

    public int createAttemptNumber() {
        attemptNumber = inputDataHandler.getNumberFromPlayer();
        return attemptNumber;
    }

}
