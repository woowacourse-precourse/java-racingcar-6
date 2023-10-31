package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int position = 0;
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }
}
