package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

// 룰렛
class Roulette {

    int spin() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
