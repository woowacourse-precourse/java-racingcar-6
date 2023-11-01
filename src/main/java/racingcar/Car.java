package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public boolean checkForward(int number) {
        if (number < GameNumber.GO.getNumber()) {
            return false;
        }

        return true;
    }
}
