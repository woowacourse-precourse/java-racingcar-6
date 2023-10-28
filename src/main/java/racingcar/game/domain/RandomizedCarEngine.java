package racingcar.game.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomizedCarEngine implements CarEngine {

    @Override
    public boolean checkWorking() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
