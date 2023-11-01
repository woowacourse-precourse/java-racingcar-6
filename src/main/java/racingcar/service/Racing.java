package racingcar.service;

import static racingcar.configurations.GameConfigurations.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class Racing {

    private Integer movingDistance;
    private Integer controlValue;
    private Integer minimumOfRange;
    private Integer maximumOfRange;

    private static class SingletonRacing {
        private static final Racing RACING = new Racing();
    }

    public static Racing getInstance() {
        return SingletonRacing.RACING;
    }

    private Racing() {
        minimumOfRange = MINIMUM_OF_RANGE.get();
        maximumOfRange = MAXIMUM_OF_RANGE.get();
        movingDistance = MOVING_DISTANCE.get();
        controlValue = CONTROL_VALUE.get();
    }

    public void playARound(List<Car> carList) {
        for (Car car : carList) {
            move(car);
        }
    }

    void move(Car car) {
        Integer randomNumber = generateRandomNumber();
        if (isMove(randomNumber)) {
            car.move(movingDistance);
        }
    }

    Boolean isMove(Integer randomNumber) {
        return (randomNumber >= controlValue);
    }

    Integer generateRandomNumber() {
        Integer randomNumber = Randoms.pickNumberInRange(minimumOfRange, maximumOfRange);
        System.out.println(randomNumber);
        return randomNumber;
    }

}
