package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovementLogic {
    public int randomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean isMoving(int num) {
        return num > 3;
    }

    public int positionUpdate(int position) {
        position += 1;
        return position;
    }
}
