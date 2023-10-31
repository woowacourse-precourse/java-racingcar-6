package racingcar.model;

import static racingcar.configurations.GameConfigurations.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {
    private Integer movingDistance;
    private Integer controlValue;
    private Integer minimumOfRange;
    private Integer maximumOfRange;

    public RandomEngine() {
        minimumOfRange = MINIMUM_OF_RANGE.get();
        maximumOfRange = MAXIMUM_OF_RANGE.get();
        movingDistance = MOVING_DISTANCE.get();
        controlValue = CONTROL_VALUE.get();
    }

    @Override
    public Integer move() {
        Integer randomNumber = generateRandomNumber();
        if (randomNumber >= controlValue) {
            return movingDistance;
        }
        return 0;
    }

    private Integer generateRandomNumber() {
        Integer randomNumber = Randoms.pickNumberInRange(minimumOfRange, maximumOfRange);
        return randomNumber;
    }

}
