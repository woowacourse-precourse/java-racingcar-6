package racingcar;

import java.util.HashMap;
import java.util.List;

public class CarMovement {
    public static boolean isMove(int randomNum) {
        return randomNum >= 4;
    }

    public static void putHM(HashMap<String, String> membersHM, List<String> members, String str) {
        for (int i = 0; i < members.size(); i++) {
            membersHM.put(members.get(i), str);
        }
    }

    public static void putHM(HashMap<String, String> memberHM, List<String> members, int n, String inputStr) {
        for (int i = 0; i < n; i++) {
            int num = PickNum.pickNum();
            if (CarMovement.isMove(num)) {
                String str = memberHM.get(members.get(i)) + inputStr;
                memberHM.put(members.get(i), str);
            }
        }
    }
}
