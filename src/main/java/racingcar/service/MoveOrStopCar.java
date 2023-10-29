package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class MoveOrStopCar {
    private Integer ramdomStartNumber = 0;
    private Integer ramdomEndNumber = 9;

    public void moveOrStopCarsForGivenTimes(Integer numberOfTimes, List<Car> cars) {
        for (int item = 0; item < numberOfTimes; item++) {
            for (Car car : cars) {
                conditionAdvancing(car);
            }
        }
    }

    public void conditionAdvancing(Car car) {
        Integer randomValue = Randoms.pickNumberInRange(ramdomStartNumber, ramdomEndNumber);

        if (randomValue >= 4) {
            car.setMoveNumber(car.getMoveNumber()+1);
        }
    }

    public void setRamdomStartNumber(Integer ramdomStartNumber) {
        this.ramdomStartNumber = ramdomStartNumber;
    }

    public void setRamdomEndNumber(Integer ramdomEndNumber) {
        this.ramdomEndNumber = ramdomEndNumber;
    }
}
