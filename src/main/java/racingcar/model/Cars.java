package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<String> carList = new ArrayList<>();
    public List<Integer> countList = new ArrayList<>();

    public Cars(String carName){
        makeCarList(carName);
    }
    public void makeCarList(String carNames) {
        for (String carName : carNames.split(",")) {
            isCarNameNull(carName);
            isCarNameOverSize(carName);
            isCarNameSame(carName, carList);
            countList.add(0);
            carList.add(carName);
        }
    }

    public static void isCarNameNull(String carName) throws IllegalArgumentException {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될수 없습니다.");
        }
    }

    public static void isCarNameSame(String carName, List<String> carList) throws IllegalArgumentException {
        if (carList.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복이 될수 없습니다.");
        }
    }

    public static void isCarNameOverSize(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 이여야 합니다.");
        }
    }
}
