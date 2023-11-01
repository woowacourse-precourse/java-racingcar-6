package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarService {

    public void race(List<Car> carList) {
        for (Car car : carList) {
            goOrStop(car);
        }
    }

    private void goOrStop(Car car) {
        int goingContidion = Randoms.pickNumberInRange(0, 9);
        if (goingContidion >= 4) {
            car.go();
        }
    }
}
