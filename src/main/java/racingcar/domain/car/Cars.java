package racingcar.domain.car;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RacingRandomNumberGenerator;

public class Cars {

    private static final int CAR_MIN_POSITION = 0;
    private static final int POSSIBLE_MOVE_NUMBER_INCLUSION = 4;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    public static Cars createCars(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> cars = carNames.stream()
                .map(name -> Car.createCar(new CarName(name), CAR_MIN_POSITION))
                .collect(Collectors.toList());
        return new Cars(cars, numberGenerator);
    }

    private Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = numberGenerator.createInRange();
            if (isPossibleMove(randomNumber)) {
                car.move();
            }
        }
    }
    private boolean isPossibleMove(int randomNumber) {
        return randomNumber >= POSSIBLE_MOVE_NUMBER_INCLUSION;
    }

    public List<Car> getWinner() {
        Car maxPosition = findMaxPositionCar(cars);
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }
    private Car findMaxPositionCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차가 없습니다."));
    }
    public List<Car> getCars() {
        return cars;
    }
}
