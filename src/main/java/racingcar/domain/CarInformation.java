package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarInformation {
    private int position = 0;

    public void move(){
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }
}
