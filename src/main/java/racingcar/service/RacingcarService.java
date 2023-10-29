package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Optional;
import racingcar.domain.Racingcar;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryRacingcarRepository;

public class RacingcarService {

    private final int movingDistance = 1;

    public int changeMoving(Racingcar racingcar) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            racingcar.setMovingforward(movingDistance);
        }

        return racingcar.getMovingforward();
    }

}
