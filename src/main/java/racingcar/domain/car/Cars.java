package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Movement;

public class Cars {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int DEFAULT_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void race() {
        cars.forEach(car -> car.move(getRandomMovement()));
    }

    private Movement getRandomMovement() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return Movement.from(randomNumber);
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream()
                .map(Car::getCarDTO)
                .toList();
    }

    public List<CarDTO> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getCarDTO)
                .toList();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }
}