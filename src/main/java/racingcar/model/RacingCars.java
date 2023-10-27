package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void checkEachCar() {
        racingCars.stream()
                .forEach(car -> car.move(Randoms.pickNumberInRange(0,9)));
    }

    public void checkEachCarWithNumber(int number) {
        racingCars.stream()
                .forEach(car -> car.move(number));
    }

    public List<Car> findWinner() {
        List<Car> winnerCars = new ArrayList<>();
        Car maxDistanceCar = racingCars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalAccessError::new);

        racingCars.stream()
                .filter(car -> maxDistanceCar.getDistance() == car.getDistance())
                .forEach(winner -> winnerCars.add(winner));

        return winnerCars;
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }
}
