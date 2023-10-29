package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class RacingCar {
    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }
}
