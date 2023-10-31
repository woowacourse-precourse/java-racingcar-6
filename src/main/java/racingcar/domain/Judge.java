package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.InputHandler;
import racingcar.NumericUtility;
import racingcar.OutputHandler;
import racingcar.Validator;

public class Judge {
    private List<Car> cars;
    private int numberOfAttempts;

    public Judge() {
        this.cars = new ArrayList<>();
    }

    public void setCars(String[] carNamesWithStringArray) {
        for (String carName : carNamesWithStringArray) {
            cars.add(new Car(carName));
        }
    }

    protected List<Car> getCars() {
        return cars;
    }
}
