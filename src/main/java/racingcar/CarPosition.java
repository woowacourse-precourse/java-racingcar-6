package racingcar;

import racingcar.domain.Car;

public enum CarPosition {

    STRAIGHT {
        public boolean increase(Car car) {
            car.increasePosition();
            return true;
        }
    },

    STOP {
        public boolean increase(Car car) {
            return false;
        }
    };

    public abstract boolean increase(Car car);

}
