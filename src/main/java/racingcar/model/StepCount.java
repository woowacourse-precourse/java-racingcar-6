package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

public class StepCount {
    private int stepCount;

    public StepCount(int stepCount) {
        if (!validateStepCount(stepCount)) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요");
        }
        this.stepCount = stepCount;
    }

    public boolean validateStepCount(int stepCount) {
        return stepCount > 0;
    }

    public int decreaseStep() {
        return --stepCount;
    }


    public boolean isStepCountZero() {
        return stepCount == 0;
    }

}
