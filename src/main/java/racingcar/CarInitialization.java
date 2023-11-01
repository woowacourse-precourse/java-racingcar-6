package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarInitialization {
    public static List<Car> initializeCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carNamesInput.split(",");

        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다. 다시 입력하세요.");
            }
            cars.add(new Car(carName));
        }

        return cars;
    }
}
