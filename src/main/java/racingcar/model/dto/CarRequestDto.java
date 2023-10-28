package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;
import racingcar.utils.Validator;
import racingcar.utils.ValidatorImp;

public class CarRequestDto {
    private static final Validator validator = new ValidatorImp();
    private final String names;

    public CarRequestDto(String names) {
        validator.validateCarName(names);
        this.names = names;
    }

    public List<Car> toCar() {
        String[] carNames = names.split(",");
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
