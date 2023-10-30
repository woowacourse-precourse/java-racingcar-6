package racingcar.domain.judgement;

import java.util.List;
import racingcar.domain.car.Car;

/**
 * 자동차 경주에 참여하는 신판 역할의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface Judgement {
        /**
         * 심판은 경기의 우승자 결과를 콘솔에 출력합니다.
         * @param carList 자동차 리스트
         */
        void announcementWinner(List<Car> carList);
}
