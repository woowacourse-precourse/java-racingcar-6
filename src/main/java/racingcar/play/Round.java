package racingcar.play;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Range;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class Round {
    private int makeRandomNum() {
        return Randoms.pickNumberInRange(Range.MIN_VALUE.getValue(), Range.MAX_VALUE.getValue());
    }

    public void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            if (makeRandomNum() >= 4) {
                car.setCount(car.getCount() + 1);
            }
        }
    }

    public void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.carInfo());
        }
    }
}
