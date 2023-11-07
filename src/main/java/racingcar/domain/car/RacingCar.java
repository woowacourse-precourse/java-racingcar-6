package racingcar.domain.car;

import racingcar.util.RandomNumber;

/**
 * 자동차 경주에 참여하는 자동차에 대한 개념 객체를 나타내는 클래스입니다.
 */
public class RacingCar implements Car {
        /**
         * 자동차의 이름입니다.
         */
        private final String name;

        /**
         * 랜덤으로 숫자를 생성해 주는 유틸 클래스입니다.
         * 자동차는 랜덤한 숫자를 선택 후 움직임을 판별합니다.
         */
        private final RandomNumber util;

        /**
         * 자동차의 주행 거리입니다.
         */
        private long drivenDistance;

        /**
         * 자동차의 생성자입니다.
         * 초기의 주행 거리를 0으로 초기화합니다.
         *
         * @param name 자동차의 이름
         * @param util 랜덤 숫자 생성 유틸 클래스
         */
        public RacingCar(final String name, RandomNumber util) {
                if (name == null || util == null) {
                        throw new IllegalArgumentException("Null은 허용되지 않습니다.");
                }

                this.name = name;
                this.util = util;
                drivenDistance = 0L;
        }

        /**
         * 자동차의 움짐임을 결정하는 메서드입니다.
         * isMoveable 메서드가 True 라면 moveForward 함수를 호출하고, False 라면 종료합니다.
         */
        @Override
        public void move() {
                if (!isMoveable()) {
                        return;
                }

                moveForward();
        }

        /**
         * 1 만큼 주행거리를 증가시킵니다.
         */
        private void moveForward() {
                drivenDistance += 1;
        }

        /**
         * 자동차가 전진할 수 있는지 판단하여 불린 값을 반환합니다.
         *
         * @return 무작위 선택 숫자가 4 이상이면 True, 4 미만이면 False
         */
        private boolean isMoveable() {
                return util.pickRandomNumber() >= 4;
        }

        /**
         * 자동차의 이름을 반환합니다.
         *
         * @return 자동차 이름
         */
        @Override
        public String getName() {
                return name;
        }

        /**
         * 자동차의 주행거리를 반환합니다.
         * @return 주행거리
         */
        @Override
        public long getDrivenDistance() {
                return drivenDistance;
        }
}
