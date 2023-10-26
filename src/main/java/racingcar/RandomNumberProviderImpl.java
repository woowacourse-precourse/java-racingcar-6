package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProviderImpl implements RandomNumberProvider{

    static final int PICK_ONE_NUMBER_START = 0;
    static final int PICK_ONE_NUMBER_END = 0;
    @Override
    public int getRandomNumber() {
        return makeRandomNumber();
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(PICK_ONE_NUMBER_START, PICK_ONE_NUMBER_END);
    }
}
