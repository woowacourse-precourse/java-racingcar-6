package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveController {
    private int createRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    public void moveCar(StringBuilder mark) {
        int move = createRandomNumber();

        if (move < 4) {
            return;
        }

        mark.append('-');
    }
}
