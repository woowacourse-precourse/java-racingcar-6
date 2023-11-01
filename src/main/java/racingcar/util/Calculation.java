package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Entity.Car;
import racingcar.constant.CarStatus;
import racingcar.constant.MagicNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculation {

    public int generateRandomNumberInRange() {
        return Randoms.pickNumberInRange(MagicNumber.RANDOM_MIN.getValue(),MagicNumber.RANDOM_MAX.getValue());
    }

    public CarStatus judgeCarMoveOrStop(int randomNumber) {
        if (randomNumber >= MagicNumber.CAM_MOVE_MIN.getValue()) {
            return CarStatus.MOVE;
        }
        return CarStatus.STOP;
    }

    public List<Car> judgeWhoIsWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        Collections.sort(cars, (o1, o2) -> o2.getMoveCount() - o1.getMoveCount());
        int maxMoveCount = cars.get(0).getMoveCount();

        for (Car car : cars) {
            if (car.getMoveCount() != maxMoveCount) {
                return winners;
            }
            winners.add(car);
        }
        return winners;
    }
}
