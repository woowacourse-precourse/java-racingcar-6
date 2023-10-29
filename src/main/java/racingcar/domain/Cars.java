package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.validation.CarNameValidator;
import racingcar.validation.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public static Cars createCars(String carNameStrings) {
        StringValidator.stringIsNull(carNameStrings);
        StringValidator.stringIsBlank(carNameStrings);
        CarNameValidator carNameValidator = new CarNameValidator(carNameStrings);
        return new Cars(carNameValidator.validate());
    }

    public CarsDto toDto() {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : this.cars) {
            carDtos.add(car.toDto());
        }
        return new CarsDto(carDtos);
    }
}
