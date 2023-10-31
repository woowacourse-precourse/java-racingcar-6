package racingcar;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingcarController {
    public static void run() {
        RacingcarView GetMembersAndTurn = new RacingcarView();
        RacingcarView StartRacing = new RacingcarView();
        RacingcarController racingcarController = new RacingcarController();

        GetMembersAndTurn.GetMembersAndTurn();
        StartRacing.StartRacing();
        racingcarController.GetMaxValues();
    }
    public static void RaceIndividually() {
        Iterator<String> keys = RacingcarModel.members.keySet().iterator();
        while(keys.hasNext()){
            MoveForward(keys.next());
        }
        System.out.println();
    }
    public static void MoveForward(String member) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            RacingcarModel.members.put(member, RacingcarModel.members.get(member)+1);
        }
        RacingcarView.printMemberStatus(member);
    }
    public void GetMaxValues() {
        Collection<Integer> values = RacingcarModel.members.values();
        RacingcarModel.maxScore = Collections.max(values);
        RacingcarView.printResult();
    }
}
