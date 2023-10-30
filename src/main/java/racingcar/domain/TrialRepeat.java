package racingcar.domain;

import java.util.Hashtable;
import camp.nextstep.edu.missionutils.Randoms;

public class TrialRepeat {
    public static final String RESULT_PRINT_TEXT = "실행 결과";

    public TrialRepeat() {
    }

    public void trialExecution(Hashtable<String, Integer> scoreboard) {
        for (String name : scoreboard.keySet()) {
            if (goOrNot()) {
                scoreboard.put(name, scoreboard.get(name) + 1);
            }
            System.out.println(name + " : " + "-".repeat(scoreboard.get(name)));
        }
        System.out.println();
    }

    private boolean goOrNot() {
        int randomInt = Randoms.pickNumberInRange(0, 9);
        return randomInt >= 4;
    }
}
