package racingcar;

public record GameRound(int roundNumber) {

    private static final int ROUND_START_NUMBER = 1;

    public GameRound(final String roundNumber) {
        this(Integer.parseInt(roundNumber));
        validatePositiveIntegers(this.roundNumber);
    }

    private void validatePositiveIntegers(int number) {
        if (number < ROUND_START_NUMBER) {
            throw new IllegalArgumentException("경주는 최소 1라운드부터 가능합니다.");
        }
    }
}
