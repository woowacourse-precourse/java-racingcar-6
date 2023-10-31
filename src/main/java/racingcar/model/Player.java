package racingcar.model;

public class Player {
    private final String CAR_NAME;
    private int completedRounds;

    public Player(String carName) {
        this.CAR_NAME = carName;
        this.completedRounds = 0;
    }

    public String getCarName() {
        return CAR_NAME;
    }

    public int getCompletedRounds() {
        return completedRounds;
    }

    public void increaseCompletedRounds() {
        this.completedRounds++;
    }

    @Override
    public String toString() {
        return CAR_NAME + " : " + "-".repeat(completedRounds);
    }
}
