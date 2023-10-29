package racingcar.model.dto;

import static racingcar.model.constants.Rule.DELIMITER;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;
import racingcar.utils.Validator;

public class CarRequestDto {
    private final String names;

    public CarRequestDto(String names) {
        Validator.validateCarName(names);
        this.names = names;
    }

    public List<Car> toCar() {
        String[] carNames = names.split(DELIMITER.getMessage());
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.from(name));
        }
        return cars;
    }

    public String getNames() {
        return names;
    }
}
