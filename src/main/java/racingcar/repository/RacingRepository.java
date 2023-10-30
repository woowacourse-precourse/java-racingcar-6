package racingcar.repository;

import racingcar.domain.Racing;
import racingcar.domain.Winners;

public interface RacingRepository extends Repository<Racing> { //이를 통해 여러 Racing 게임의 기록을 담고 재게임이 가능하다.

    //Winner 정보 입력
    void updateWinners(Winners winners);
}
