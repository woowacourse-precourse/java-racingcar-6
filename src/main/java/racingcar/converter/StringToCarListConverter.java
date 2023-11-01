package racingcar.converter;

import racingcar.game.components.Car;
import racingcar.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class StringToCarListConverter {

    private final InputValidator inputValidator = new InputValidator();

    public List<Car> execute(String carNames) {
        inputValidator.carName(carNames);

        List<Car> cars = new ArrayList<>();
        String[] items = carNames.split(",");

        for (String item : items) {
            cars.add(new Car(item.trim()));
        }

        return cars;
    }

}
