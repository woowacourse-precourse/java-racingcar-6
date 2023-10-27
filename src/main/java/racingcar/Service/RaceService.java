package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceService {

    public int RandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

}
