package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private int movementNumber = Randoms.pickNumberInRange(0, 9);
    List<String> movement = new ArrayList<>();

    public void decideAction() {
        if (movementNumber >= 4) {
            movement.add("-");
        }
    }
}
