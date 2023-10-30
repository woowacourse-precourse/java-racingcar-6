package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class GameSetting {

    public InputDataHandler inputDataHandler = new InputDataHandler();
    private HashMap<String, Integer> cars;
    private String[] inputCarNames;
    private int attemptNumber;

    public HashMap<String, Integer> createCarName() {
        cars = inputDataHandler.getStringFromPlayer();
        return cars;
    }

    public int createAttemptNumber() {
        attemptNumber = inputDataHandler.getNumberFromPlayer();
        return attemptNumber;
    }

}
