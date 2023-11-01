package racingcar.domain;

import java.util.List;

public class Car {

    public void correctCarName(String[] carNameArr) {
        for (int i = 0; i < carNameArr.length; i++) {
            numberOfCharacters(carNameArr, i);
        }
    }

    public void numberOfCharacters(String[] carNameArr, int i) {
        if (carNameArr[i].length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName(String cars) {
        String[] carName = cars.split(",");
        return carName;
    }

    public void forwardStrReset(List<String> forwardCountStr, String[] carNameArr) {
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountStr.add("");
        }
    }

    public void forwardIntReset(List<Integer> forwardCountInt, String[] carNameArr) {
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountInt.add(0);
        }
    }
}