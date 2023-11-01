package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    int generatedNum;
    public int generateRandomNum() {
        return generatedNum = Randoms.pickNumberInRange(0, 9);
    }
}
