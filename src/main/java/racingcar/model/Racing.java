package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {


    public boolean moveForward() {
        int forwardPossibility = generateNumber();
        boolean go = false;
        if (forwardPossibility >= 4) {
            go = true;
        }
        return go;
    }

    public int generateNumber() {
        return Randoms.pickNumberInRange(1, 10) - 1;
    }
}
