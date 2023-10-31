package racingcar;

import java.util.HashMap;
import java.util.List;

public class CarMovement {
    public static boolean isMove(int randomNum) {
        return randomNum >= 4;
    }

    public static void putHM(HashMap<String, String> membersHM, List<String> members, String str) {
        for (int i = 0; i < members.size(); i++) {
            int randomNum = PickNum.pickNum();

            if (isMove(randomNum) && membersHM.get(members.get(i)).equals("")) {
                membersHM.put(members.get(i), "-");
            } else if (isMove(randomNum)) {
                membersHM.put(members.get(i), membersHM.get(members.get(i)) + str);
            }
        }
    }
}
