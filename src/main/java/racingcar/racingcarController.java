package racingcar;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.racingcarModel;
import racingcar.racingcarView;

public class racingcarController {
    public static void run() {
        racingcarView GetMembersAndTurn = new racingcarView();
        racingcarView StartRacing = new racingcarView();
        racingcarController racingcarController = new racingcarController();

        GetMembersAndTurn.GetMembersAndTurn();
        StartRacing.StartRacing();
        racingcarController.GetMaxValues();
    }
    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }
    public static void RaceIndividually() {
        Iterator<String> keys = racingcarModel.members.keySet().iterator();
        while(keys.hasNext()){
            MoveForward(keys.next());
        }
        System.out.println();
    }
    public static void MoveForward(String member) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            racingcarModel.members.put(member, racingcarModel.members.get(member)+1);
        }
        racingcarView.printMemberStatus(member);
    }
    public void GetMaxValues() {
        Collection<Integer> values = racingcarModel.members.values();
        racingcarModel.maxScore = Collections.max(values);
        racingcarView.printResult();
    }
}
