package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private int randomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    private void moveForward(List<User> users) {
        for (User u : users) {
            int randomNum = randomNumber();
            if (randomNum < 4) {
                continue;
            }
            u.length += 1;
        }
    }


}
