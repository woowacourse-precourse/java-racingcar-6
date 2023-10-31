package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class Policy implements NumberGenerator, CarMoveForward {
    @Override
    public boolean isCarMoveForward(int randomNumber) {
        return randomNumber >= 4;
    }

    @Override
    public int getRandomDecimalNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
