package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final CarState carState;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car name length must be 5 or less (" + name + ")");
        }
        this.name = name;
        this.carState = new CarState();
    }

    public void run() {
        carState.move(Randoms.pickNumberInRange(0, 9));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return carState.getPosition();
    }

    private static class CarState {
        private int position;

        public CarState() {
            this.position = 0;
        }

        public void move(int random) {
            if (random >= 4) {
                position++;
            }
        }

        public int getPosition() {
            return position;
        }
    }
}
