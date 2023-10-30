package racingcar.model;

public record IsWinner(boolean isWinner) {

    public static IsWinner init() {
        return new IsWinner(false);
    }
}
