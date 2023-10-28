package racingcar.domain.caractions;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomStepGenerator {

    public int getStep() {
        int step;
        step = generateRandomStep();
        if (isValidStep(step)){
            return step;
        }
        return 0;
    }


    private int generateRandomStep() {
        return pickNumberInRange(0, 9);
    }

    private Boolean isValidStep(int step) {
        return step >= 4;
    }
}