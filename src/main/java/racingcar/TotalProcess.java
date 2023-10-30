package racingcar;

public class TotalProcess {
    TotalProcess() {
    }

    public void runTotalProcess() {
        CarNameInput carNameInput = new CarNameInput();
        carNameInput.exceptionHandling();

        MoveInput moveInput = new MoveInput();
        moveInput.exceptionHandling();

        PlayGame playGame = new PlayGame(carNameInput.getNameList());
        for (int i = 0; i < moveInput.getMove(); i++) {
            playGame.simulation();
            playGame.printResult();
        }
        playGame.printWinnerList();
    }

}
