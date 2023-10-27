package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int defaultPosition = 0;

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = Car.defaultPosition;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name + " : ");
        for(int i = 0; i < this.position; i++) {
            builder.append('-');
        }
        return builder.toString();
    }

    public void move() {
        int randNum = Randoms.pickNumberInRange(0, 9);

        if (randNum >= 4) {
            this.position++;
        }
    }

    public boolean isWinner(int farthestPosition) {
        return this.position == farthestPosition;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
