package racingcar;

import java.util.ArrayList;

public class GameSetting {

    public InputDataHandler inputDataHandler = new InputDataHandler();
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
