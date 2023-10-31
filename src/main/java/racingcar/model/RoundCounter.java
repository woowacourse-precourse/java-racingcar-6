package racingcar.model;

public class RoundCounter {
    private final TotalNumberOfRounds totalNumberOfRounds;
    private int currentRoundNumber;

    public RoundCounter(int totalNumberOfRounds) {
        this.totalNumberOfRounds = new TotalNumberOfRounds(totalNumberOfRounds);
        currentRoundNumber = 1;
    }

    public boolean hasNextRound() {
        return currentRoundNumber <= totalNumberOfRounds.getTotal();
    }

    public void plusOne() {
        currentRoundNumber++;
    }
}
