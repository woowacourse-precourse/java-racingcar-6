package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Movement;

public class Cars {
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
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return Movement.from(randomNumber);
    }
}