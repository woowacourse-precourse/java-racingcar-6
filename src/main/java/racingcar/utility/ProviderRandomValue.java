package racingcar.utility;

import camp.nextstep.edu.missionutils.Randoms;

public class ProviderRandomValue {

    public ProviderRandomValue() {
    }

    public int returnRandomNumeric() {
        return Randoms.pickNumberInRange(0,9);
    }

}
