package racingcar.domain.player;

import java.math.BigInteger;
import java.util.List;

/**
 * 자동차 경주에 참여하는 플레이어의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface RacingPlayer {
        /**
         * 플레이어는 자동차의 이름을 입력할 수 있다.
         *
         * @param nameLength 자동차 이름의 제한 길이
         * @return 자동차 이름 리스트
         */
        List<String> submitRacingCarNameList(int nameLength);

        /**
         * 플레이어는 게임의 laps 를 입력할 수 있다.
         * @return laps
         */
        BigInteger submitLaps();
}
