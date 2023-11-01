package racingcar.domain;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.dto.CarStatus;
import racingcar.domain.dto.CarsStatus;
import racingcar.utill.NumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<Car> carList, NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>(carList);
        this.numberGenerator = numberGenerator;
    }

    public CarsStatus decisionCarsMove() {
        List<CarStatus> carsResponses = new ArrayList<>();

        for (Car car : cars) {
            int carPosition = car.move(numberGenerator.generateNumber());
            String carName = car.getName();
            carsResponses.add(CarStatus.of(carName, carPosition));
        }

        return CarsStatus.from(carsResponses);
    }

    public String findWinner() {
        List<String> winners = cars.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .map(Car::getName)
                .toList();

        return String.join(", ", winners);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(INIT_POSITION);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
