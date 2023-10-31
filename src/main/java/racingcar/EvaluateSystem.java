package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class EvaluateSystem {
    public static ArrayList<Integer> racingCondition(int inputCount) {
        ArrayList<Integer> temp = new ArrayList<>();
        int carStatus;
        for (int i = 0; i < inputCount; i++) {
            temp.add(Randoms.pickNumberInRange(0,9));
        }
        return temp;
    }
    public void winnerDisplay() {

    }
    public void winnerCount() {

    }
}
