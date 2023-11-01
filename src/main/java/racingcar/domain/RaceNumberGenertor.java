package racingcar.domain;

import racingcar.util.NumberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.domain.constant.RaceConstant.MAX_RACE_CONDITION;
import static racingcar.domain.constant.RaceConstant.MIN_RACE_CONDITION;

public class RaceNumberGenertor implements NumberGenerator {
    
    private final int minNumber = MIN_RACE_CONDITION.getValue();
    
    private final int maxNumber = MAX_RACE_CONDITION.getValue();

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }
}
