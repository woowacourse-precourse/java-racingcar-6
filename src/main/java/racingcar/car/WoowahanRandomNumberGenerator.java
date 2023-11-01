package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class WoowahanRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate(){
        return Randoms.pickNumberInRange(0,9);
    }
}
