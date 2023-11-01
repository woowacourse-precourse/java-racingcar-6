package racingcar.service;

public class RaceService {
    private RaceGame raceGame;
    private int currentTryNumber = 0;

    public void makeCarList(String carNames) {
        raceGame = new RaceGame(carNames);
    }

    public void makeTryNumber(String tryCount) {
        raceGame.makeTryNumber(tryCount);
    }

    public String playOneRound() {
        currentTryNumber++;
        return raceGame.moveAllCars();
    }

    public boolean isEnd() {
        return raceGame.isEnd(currentTryNumber);
    }

    public String calculateWinners() {
        return raceGame.calculateWinner();
    }
}
