package Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car {
    private int randomNumber;

    public void generateRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    // test용 코드
    public boolean isRandomNumberInRange0to9() {
        return randomNumber >= 0 && randomNumber <= 9;
    }
}
