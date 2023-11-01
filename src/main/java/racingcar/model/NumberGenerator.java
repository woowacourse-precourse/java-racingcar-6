package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.RuleConstant;

public class NumberGenerator {
    public static int getNumber(){
        return Randoms.pickNumberInRange(RuleConstant.START_INCLUSIVE,RuleConstant.END_INCLUSIVE);
    }
}
