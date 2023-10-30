package racingcar.model;

import static racingcar.validator.InputValidator.validateLenOfCar;

import java.util.List;

public class Match {
    private List<Car> carList;
    private int numOfMatch;

    public Match(String carListString) {
        validateLenOfCar(carListString);

        for (String carString : carListString.split(",")) {
            this.carList.add(new Car(carString));
        }
    }
}
