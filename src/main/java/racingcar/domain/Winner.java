package racingcar.domain;

public class Winner {

    private final String winner;

    public Winner(String carName) {
        winner = carName;
    }

    @Override
    public String toString() {
        return winner;
    }
}
