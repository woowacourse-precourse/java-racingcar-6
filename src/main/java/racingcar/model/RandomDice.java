package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDice implements Dice {

    @Override
    public int roll() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
