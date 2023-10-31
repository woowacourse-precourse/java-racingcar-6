package racingcar.service;

import java.util.List;
import racingcar.dto.RacingStatus;

public class RacingService {
    RacingStatus status = new RacingStatus();

    public void initGame(List<String> carNames, int numberOfAttempt){
        status.setCarList(carNames);
        status.setNumberOfAttempt(numberOfAttempt);
    }
}
