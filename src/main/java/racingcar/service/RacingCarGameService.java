package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameResult;

public class RacingCarGameService {

    public List<Car> forwardOrStop(List<Car> carList) {
        return carList.stream()
                    .map(
                        car -> {
                            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                                return Car.moveForwardCar(car);
                            }
                            return car;
                    }).toList();
    }

    public GameResult winnerResult(List<Car> carList) {
        int maxDistance = carList.stream()
                .mapToInt(car -> car.getDistance())
                .max()
                .orElse(Integer.MIN_VALUE);

        List<Car> winners = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
        return GameResult.from(winners);
    }
}
