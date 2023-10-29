package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionUtilsGameRandom implements GameRandom{

    public int randomNumberRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
