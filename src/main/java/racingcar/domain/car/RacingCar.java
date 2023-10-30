package racingcar.domain.car;

import racingcar.util.RandomNumber;

public class RacingCar implements Car {
        private final String name;
        private final RandomNumber util;
        private long drivenDistance;

        public RacingCar(final String name, RandomNumber util) {
                this.name = name;
                this.util = util;
                drivenDistance = 0L;
        }

        @Override
        public void move() {
                if (!isOverFour(util.pickRandomNumber())) {
                        return;
                }

                drivenDistance += 1;
        }

        private boolean isOverFour(final int randomNumber) {
                return randomNumber >= 4;
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public long getDrivenDistance() {
                return drivenDistance;
        }
}
