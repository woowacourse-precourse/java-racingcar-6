package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        checkOver5Letters(name);
        checkCarWithBlank(name);
        return new Car(name);
    }

    public static void checkOver5Letters(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 6글자 이상일 수 없습니다.");
        }

    }

    public static void checkCarWithBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 공백만 있을 수 없습니다.");
        }
    }

    public String[] carsByStringToArray(String inputAllCars) {
        return inputAllCars.split(",");
    }

    public void checkDuplicateCarName(String[] cars) {
        List<String> carList = new ArrayList<>();
        for (String car : cars) {
            if (carList.contains(car)) {
                throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다");
            }
            carList.add(car);
        }
    }
}
