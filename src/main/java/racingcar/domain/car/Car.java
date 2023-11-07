package racingcar.domain.car;

/**
 * 자동차 경주에 참여하는 자동차의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface Car {
        /**
         * 자동차는 정진 혹은 정지할 수 있습니다.
         */
        void move();

        /**
         * 주행거리를 반환합니다.
         *
         * @return 주행거리
         */
        long getDrivenDistance();

        /**
         * 자동차의 이름을 반환합니다.
         *
         * @return 자동차 이름
         */
        String getName();
}
