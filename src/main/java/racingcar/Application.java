package racingcar;

import static racingcar.domain.Car.carName;
import static racingcar.view.input.inputCarName;
import static racingcar.view.input.inputNumberCarsRace;

public class Application {
    public static void main(String[] args) {
        carName(inputCarName());
        inputNumberCarsRace();
    }
}
