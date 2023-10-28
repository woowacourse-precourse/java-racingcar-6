package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private Integer tryCount;

    private Cars cars;

    public void initCars() {
        String[] carsNames = getCarNames();
        this.cars = makeCars(carsNames);
    }

    private String[] getCarNames() {
        return Converter.splitCarNameWithComma(InputView.inputCarNames());
    }

    private Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

}
