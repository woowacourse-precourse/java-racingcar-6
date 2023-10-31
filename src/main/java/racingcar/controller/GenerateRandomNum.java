package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNum {
    public boolean pickNum(int randomNum) {
        int MOVE_FORWARD = 4;
        if (randomNum >= MOVE_FORWARD) {
            return true;
        }
        return false;
    }
}
