package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private final int MIN=0;
    private final int MAX=9;

    private boolean decideStopOrProceed(){
        return Randoms.pickNumberInRange(MIN,MAX) >=4;
    }

}
