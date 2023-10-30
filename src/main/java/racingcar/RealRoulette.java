package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

final class RealRoulette implements Roulette{

    @Override
    public int spin() {
        return Randoms.pickNumberInRange(Rule.FROM.value, Rule.TO.value);
    }
}
