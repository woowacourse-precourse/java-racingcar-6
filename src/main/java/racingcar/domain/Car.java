package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    CarName carName = new CarName();
    int carCount = carName.inputCarName().size();

    public void racingCarCount() {
        for (int i = 0; carCount < i; i++) {
            goControlStatement(getRandomNumber());
        }
    }

    public final int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public final int goControlStatement(int RandomNumber) {
        if (RandomNumber >= 4) {
            return 1;
        }
        return 0;
    }
}
