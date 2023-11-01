package racingcar.model;

import racingcar.model.dto.CarStatusDto;
import racingcar.util.NumberGenrator;
import racingcar.util.RandomNumberGenrator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final static NumberGenrator randomNumberGenerator = new RandomNumberGenrator();

    public Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public void eachCarMoveOrStop() {
        cars.forEach(car -> car.moveOrStop(randomNumberGenerator.generate()));
    }

    public List<CarStatusDto> printCarsStatus() {
        return cars.stream().map(CarStatusDto::new).toList();
    }

    public int findCarsMaxPosition() {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = Math.max(car.getPosition(),maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars.stream().collect(Collectors.toUnmodifiableList());
    }
}
