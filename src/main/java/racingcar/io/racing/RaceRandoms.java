package racingcar.io.racing;

import racingcar.io.Randoms;

public class RaceRandoms implements Randoms {


    @Override
    public int getSingleNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

}
