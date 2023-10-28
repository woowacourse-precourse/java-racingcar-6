package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class RacingGame {

    public HashMap<String, Integer> playGame(HashMap<String, Integer> userResult) {

        for (String userName : userResult.keySet()) {
            int number = Randoms.pickNumberInRange(0, 9);

            if (number >= 4) {
                userResult.put(userName, userResult.get(userName) + 1);
            }
        }

        return userResult;
    }

}
