package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MoveChecker {
    public List<Integer> checkMoveOrStop(List<String> members, List<Integer> count) {
        ResultPrinter resultPrinter = new ResultPrinter();
        int MembersSize = members.size();
        for (int i = 0; i < MembersSize; i++) {
            int RandomNumber = Randoms.pickNumberInRange(0, 9);
            if (RandomNumber >= 4) {
                count.set(i, count.get(i) + 1);
            }
            resultPrinter.printResult(members.get(i), count.get(i));
        }
        return count;
    }
}
