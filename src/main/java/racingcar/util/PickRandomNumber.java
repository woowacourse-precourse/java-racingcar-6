package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;

public class PickRandomNumber {
    public PickRandomNumber(){}

    public static Integer generate(){
        return Randoms.pickNumberInRange(MIN_NUM.getPlayValue(), MAX_NUM.getPlayValue());
    }
}
