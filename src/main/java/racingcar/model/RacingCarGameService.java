package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RacingCarGameService {
    private static final int MOVING_FORWARD = 4;

    public RacingCarGameService() {

    }

    public RacingResult continueGame(RacingResult racingResult) {

        // 리스트 순회하면서 결정
        for (String carName : racingResult.getNames()) {
            if(MOVING_FORWARD <= Randoms.pickNumberInRange(0, 9)) {
                racingResult.moveForward(carName);
            }
        }

        return racingResult;
    }
}
