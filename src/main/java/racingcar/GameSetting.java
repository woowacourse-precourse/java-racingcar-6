package racingcar;

import java.util.ArrayList;

public class GameSetting {

    public InputDataHandler inputDataHandler = new InputDataHandler();
    public InputValidator inputValidator = new InputValidator();
    private String[] carNames;
    private ArrayList<Car> carArray = new ArrayList<>();
    private String attemptNumber;

    public ArrayList<Car> createCarName() {
        carNames = inputDataHandler.getStringFromPlayer();
        inputValidator.checkString(carNames);
        for (String carName : carNames) {
            carArray.add(new Car(carName));
        }
        return carArray;
    }

    public int createAttemptNumber() {
        attemptNumber = inputDataHandler.getNumberFromPlayer();
        inputValidator.checkNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }

}
