package racingcar.domain;

import java.util.Hashtable;
import camp.nextstep.edu.missionutils.Randoms;

public class TrialRepeat {
    public static final String RESULT_PRINT_TEXT = "실행 결과";
    public Hashtable<String, Integer> sb;

    public TrialRepeat(Hashtable<String, Integer> scoreboard) {
        sb = scoreboard;
    }

    public void trialExecution() {
        for (String name : sb.keySet()) {
            System.out.println(personalScore(name, goOrNot()));
        }
        System.out.println();
    }

    public String personalScore(String name, boolean go) {
        if (go) {
            sb.put(name, sb.get(name) + 1);
        }
        return name + " : " + "-".repeat(sb.get(name));
    }

    private boolean goOrNot() {
        int randomInt = Randoms.pickNumberInRange(0, 9);
        return randomInt >= 4;
    }
}
