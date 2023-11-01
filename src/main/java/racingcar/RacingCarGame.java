package racingcar;

public class RacingCarGame {


    public void play() {

        RaceInfo raceInfo = getRaceInfo();
        CarMoveDisplay.carMove(raceInfo);
        WinnerVerifyDisplay.winnerPrint(WinnerVerifyDisplay.verifyWinner(raceInfo));

    }

    public RaceInfo getRaceInfo() {

        String[] carNames = RaceInfoInput.inputCarName();
        String attemptCount = RaceInfoInput.inputNumberOfAttempts();
        return new RaceInfo(carNames, attemptCount);

    }


}
