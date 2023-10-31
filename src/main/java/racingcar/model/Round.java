package racingcar.model;

public class Round {
    private final TotalNumberOfRounds totalNumberOfRounds;
    private int currentRoundNumber;

    public Round(int totalNumberOfRounds) {
        this.totalNumberOfRounds = new TotalNumberOfRounds(totalNumberOfRounds);
        currentRoundNumber = 1;
    }

    public boolean over() {
        return currentRoundNumber > totalNumberOfRounds.getTotal();
    }

    public void plusOne() {
        currentRoundNumber++;
    }
}
