package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingcarService {

    public Advance game(){
        int advanceCount = Randoms.pickNumberInRange(0,9);

        if (advanceCount < 4){
            return new Advance(false, advanceCount);
        }

        return new Advance(true, advanceCount);
    }

}
