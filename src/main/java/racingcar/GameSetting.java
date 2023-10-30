package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class GameSetting {

    public InputDataHandler inputDataHandler = new InputDataHandler();
    private HashMap<String, Integer> cars = new HashMap<>();
    private String[] inputCarNames;
    private int attemptNumber;
    private String carName;


    public HashMap<String, Integer> createCarName() {
        cars = inputDataHandler.getStringFromPlayer();
        return cars;
    }

    public String getCarName(int index) {
        carName = inputDataHandler.findCarName(index);
        return carName;
    }

    public int createAttemptNumber() {
        attemptNumber = inputDataHandler.getNumberFromPlayer();
        return attemptNumber;
    }

    public int getCarMoveForward(String carName) {
        return cars.get(carName);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
