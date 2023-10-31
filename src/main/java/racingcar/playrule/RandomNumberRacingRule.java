package racingcar.playrule;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author 민경수
 * @description random number moveable play rule
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RandomNumberRacingRule implements RacingRule {

    @Override
    public boolean isMovable(int number) {
        return number >= 4;
    }

}