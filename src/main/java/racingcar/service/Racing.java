package racingcar.service;

import static racingcar.configurations.GameConfigurations.CONTROL_VALUE;
import static racingcar.configurations.GameConfigurations.MAXIMUM_OF_RANGE;
import static racingcar.configurations.GameConfigurations.MINIMUM_OF_RANGE;
import static racingcar.configurations.GameConfigurations.MOVING_DISTANCE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class Racing {
    private Integer movingDistance;
    private Integer controlValue;
    private Integer minimumOfRange;
    private Integer maximumOfRange;


    public Racing() {
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

    private void move(Car car) {
        Integer randomNumber = generateRandomNumber();
        if (isMove(randomNumber))
            car.move(movingDistance);
    }

    private Boolean isMove(Integer randomNumber) {
        return (randomNumber >= controlValue);
    }

    private Integer generateRandomNumber() {
        Integer randomNumber = Randoms.pickNumberInRange(minimumOfRange, maximumOfRange);
        return randomNumber;
    }

}
