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

    private Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }
    public static Cars createCars(List<String> carNames, NumberGenerator numberGenerator) {
        validate(carNames);
        List<Car> cars = carNames.stream()
                .map(name -> Car.createCar(new CarName(name), CAR_MIN_POSITION))
                .collect(Collectors.toList());
        return new Cars(cars, numberGenerator);
    }

    private static void validate(List<String> carNames) {
        validateSize(carNames);
        validateDuplicate(carNames);
    }

    private static void validateSize(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("차는 두대이상 존재 해야합니다");
        }
    }

    private static void validateDuplicate(List<String> carNames) {
        boolean hasDuplicate = carNames.stream()
                .distinct()
                .count() != carNames.size();
        if(hasDuplicate) {
            throw new IllegalArgumentException("차의 이름은 중복되면 안됩니다");
        }
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
