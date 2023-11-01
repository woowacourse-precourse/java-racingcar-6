package racingcar.service.impl;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.AppConfig.MAX_DICE_NUMBER;
import static racingcar.AppConfig.MIN_DICE_NUMBER;

import racingcar.service.Dice;

public class RandomDiceImpl implements Dice {
    @Override
    public int roll() {
        return pickNumberInRange(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }
}
