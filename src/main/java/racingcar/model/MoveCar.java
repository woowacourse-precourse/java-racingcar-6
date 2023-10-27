package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;

public class MoveCar {
    HashMap<String, Integer> carPositionMap = new HashMap<>();
    List<String> carNameList;
    private Integer tryNumber;

    public MoveCar(List<String> carNameList, String userInputTryNumber) {
        InputValidator.validateNumber(userInputTryNumber);
        this.carNameList = carNameList;
        initializeCarPositionMap(carNameList);
        this.tryNumber = Integer.parseInt(userInputTryNumber);
    }

    public void initializeCarPositionMap(List<String> carNameList) {
        for (String carName:carNameList) {
            carPositionMap.put(carName, 0);
        }
    }

    public HashMap<String, Integer> getCarPositionMap() {
        return carPositionMap;
    }
    public void moveCarTryNumber() {
        for (int i=0;i<tryNumber;i++) {
            moveAllCarOnce();
        }
    }

    private void moveAllCarOnce() {
        for (String carName:carNameList) {
            moveCarOnce(carName);
        }
    }

    private void moveCarOnce(String carName) {
        if (isMove()) {
            int carPosition = carPositionMap.get(carName);
            carPosition++;
            carPositionMap.replace(carName, carPosition);
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
