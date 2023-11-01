package racingcar.model;

public class Game {

    private final Cars cars;
    private final TrialNumber trialNumber;

    public Game(Cars cars, TrialNumber trialNumber) {
        this.cars = cars;
        this.trialNumber = trialNumber;
    }

    public void playGame(Cars cars) {
        cars.moveCars();
    }

    public void nextRound(TrialNumber trialNumber) {
        trialNumber.decreaseTrialNumber();
    }

    public boolean isGameEnd(TrialNumber trialNumber) {
        return trialNumber.isTrialNumberZero();
    }

}
