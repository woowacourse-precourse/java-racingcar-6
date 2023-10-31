package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import game.GameRandom;

public class MissionUtilsGameRandom implements GameRandom {

    public int randomNumberRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end - 1);
    }
}
