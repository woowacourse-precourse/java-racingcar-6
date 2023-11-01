package racingcar.domain;

import java.util.List;

public class Car {
    String[] carNameArr;

    public String[] correctCarName(String car) {
        carNameArr = splitCarName(car);
        for (int i = 0; i < carNameArr.length; i++) {
            numberOfCharacters(i);
        }
        return carNameArr;
    }

    public void numberOfCharacters(int i) {
        if (carNameArr[i].length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName(String cars) {
        String[] carName = cars.split(",");
        return carName;
    }

    public void forwardStrReset(List<String> forwardCountStr) {
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountStr.add("");
        }
    }

    public void forwardIntReset(List<Integer> forwardCountInt) {
        for (int i = 0; i < carNameArr.length; i++) {
            forwardCountInt.add(0);
        }
    }
}