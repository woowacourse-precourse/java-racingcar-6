package racingcar.service;

import racingcar.domain.Racing;

public interface RacingService {

    void save(Racing racing);
    void racing(Racing racing);

    Racing generateRacing(String carNames, String tryCount);
}
