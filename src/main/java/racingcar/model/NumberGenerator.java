package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;

public class NumberGenerator {
    public int generateNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
