package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameController implements GameControllable {
    public void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    public void play(List<Car> carList, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : carList) {
                moveOrNot(car);
                System.out.println(car.status());
            }
        }
    }

    @Override
    public void moveOrNot(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    @Override
    public void play(List<Car> carList, int attemptCount, int[] randomNumberList) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : carList) {
                moveOrNot(car, randomNumberList[i]);
                System.out.println(car.status());
            }
        }
    }
}

