package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class TrialRepeat {
    public static final String RESULT_PRINT_TEXT = "실행 결과";

    public TrialRepeat() {
    }

    public void trialExecution(List<String> names) {
        for (String name : names) {
            System.out.print(name + " : ");
            if (goOrNot()) {
                
            }
        }
    }

    private boolean goOrNot() {
        int randomInt = Randoms.pickNumberInRange(0, 9);
        return randomInt >= 4;
    }

}
