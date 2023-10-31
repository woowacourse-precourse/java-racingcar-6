package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.configurations.Configurations;

public class Accelerator {
    private Integer movingDistance;
    private Integer controlValue;
    private Integer minimumOfRange;
    private Integer maximumOfRange;

    public Accelerator(Configurations configurations) {
        movingDistance = configurations.getMovingDistance();
        controlValue = configurations.getControlValue();
        minimumOfRange = configurations.getMinimumOfRange();
        maximumOfRange = configurations.getMaximumOfRange();
    }

    public Integer advance() {
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
