package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.validator.CarNamesValidator;
import racingcar.dto.CarDto;
import racingcar.utils.RandomNumber;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final RandomNumber randomNumber;

    public Cars(final List<String> names, final RandomNumber randomNumber) {
        names.forEach(name -> cars.add(new Car(name)));
        CarNamesValidator.validateCarNames(names);
        this.randomNumber = randomNumber;
    }

    public List<CarDto> getCarStatus() {
        return cars.stream()
                .map(Cars::convertToDto)
                .toList();
    }

    private static CarDto convertToDto(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public void checkCarIsMovable() {
        cars.forEach(car -> car.moveForward(randomNumber));
    }
}
