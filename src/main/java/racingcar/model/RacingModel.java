package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.domain.RacingConfig.FORWARD_NUMBER;
import static racingcar.domain.RacingConfig.MAX_NUMBER;
import static racingcar.domain.RacingConfig.MIN_NUMBER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingModel {

    public void proceed(List<Car> cars) {
        do {
            generateRandomNumbers(cars);
            moveForwards(cars);
        } while (cars.stream().allMatch(car -> car.getRound() < car.getFinalRound()));
    }

    private void generateRandomNumbers(List<Car> cars) {
        for (Car car : cars) {
            car.setRandomNumber(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    private void moveForwards(List<Car> cars) {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        if (car.getRandomNumber() >= FORWARD_NUMBER){
            car.increaseMoveResult();
        }
        car.increaseRound();
    }
}
