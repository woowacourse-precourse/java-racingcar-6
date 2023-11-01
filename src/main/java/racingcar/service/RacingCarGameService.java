package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGameService {

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}
