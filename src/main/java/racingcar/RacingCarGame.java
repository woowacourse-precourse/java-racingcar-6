package racingcar;

public class RacingCarGame {
//    private RaceInfo raceInfo;

    public void play() {

//        CarMoveDisplay carMoveDisplay = new CarMoveDisplay(raceInfo);
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
