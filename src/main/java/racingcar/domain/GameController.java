package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameController {
    public void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    public void play(List<Car> carList, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : carList) {
                car.forward();
                System.out.println(car.status());
            }
        }
    }
}

