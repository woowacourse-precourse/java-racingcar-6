package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class GameModel {
    private Map<String, Integer> carData;

    public GameModel() {
        carData = new LinkedHashMap<>();
    }

    public void insertCarToCarArray(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            carData.put(carName, 0);
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkResult(int randInt) {
        return randInt >= 4;
    }

    public void putDataToCarData(String carName, int count) {
        carData.put(carName, carData.get(carName) + count);
    }

    public int findMaxPosition() {
        return carData.values().stream().max(Integer::compare).orElse(0);
    }

    public Map<String, Integer> getCarData() {
        return carData;
    }
}

