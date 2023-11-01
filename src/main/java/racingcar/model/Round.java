package racingcar.model;

public class Round {
    Integer numberOfRound;

    public Round(Integer numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public Boolean IsNotEnd() {
        return (numberOfRound >= 0);
    }

    public void finishARound() {
        numberOfRound--;
    }
}
