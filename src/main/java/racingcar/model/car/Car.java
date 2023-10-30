package racingcar.model.car;

import racingcar.model.RandomNumberGenerator;

public record Car(Name name, Position position) {
    private static final int FORWARD_NUMBER = 4;

    public void race() {
        int number = RandomNumberGenerator.generate();
        if (FORWARD_NUMBER <= number) {
            this.position.plus();
        }
    }
}
