package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

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
}
