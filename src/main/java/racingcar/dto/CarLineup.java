package racingcar.dto;

import static racingcar.messages.ViewMessage.INPUT_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.InputValidator;

public class CarLineup {
    private List<Car> cars = new ArrayList<>();
    private InputValidator validator = InputValidator.getInstance();

    public CarLineup(String carNames) throws IllegalArgumentException {
        validator.validateNameDuplication(carNames);
        String[] names = carNames.split(INPUT_SEPARATOR);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
