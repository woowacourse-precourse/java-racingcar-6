package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class GameController {
    private String carName;
    private HashMap<String, Integer> cars;
    public InputDataHandler inputDataHandler = new InputDataHandler();

    public String getCarName(int index) {
        carName = inputDataHandler.findCarName(index);
        return carName;
    }

    public int getCarMoveForward(String carName) {
        return inputDataHandler.findCarMovement(carName);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
