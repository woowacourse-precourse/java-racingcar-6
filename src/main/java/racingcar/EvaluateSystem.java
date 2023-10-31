package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class EvaluateSystem {
    public static ArrayList<Integer> racingCondition(int inputCount) {
        ArrayList<Integer> racingInProcess = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            racingInProcess.add(Randoms.pickNumberInRange(0,9));
        }
        return racingInProcess;
    }
    public void winnerDisplay() {

    }
    public void winnerCount() {

    }
}
