package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Car {
        private final String name;
        private long drivenDistance;

        public RacingCar(String name) {
                this.name = name;
                drivenDistance = 0L;
        }

        @Override
        public void move() {
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                if (randomNumber >= 4) {
                        drivenDistance += 1;
                }
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public long getDrivenDistance() {
                return drivenDistance;
        }

        @Override
        public String toString() {
                return "RacingCar{" +
                        "name='" + name + '\'' +
                        '}';
        }
}
