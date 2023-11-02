package racingcar.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.RacingService;

public class RacingServiceImpl implements RacingService {
    @Override
    public boolean isCanGoOneSpace() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
