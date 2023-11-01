package racingcar.model;

public class Round {
    Integer numberOfRounds;

    public Round(Integer numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Boolean IsNotEnd() {
        return (numberOfRounds >= 0);
    }

    public void finishARound() {
        numberOfRounds--;
    }
}
