package racingcar;

public class RacingCarGame {

    public void play() {
        RaceInfo raceInfo = getRaceInfo();
        CarMoveDisplay.carRace(raceInfo);
        WinnerDisplay.winnerPrint(WinnerDisplay.verifyWinner(raceInfo));


    }

    public RaceInfo getRaceInfo() {

        String[] carNames = RaceInfoInput.inputCarName();
        String attemptCount = RaceInfoInput.inputNumberOfAttempts();
        return new RaceInfo(carNames, attemptCount);

    }
}
