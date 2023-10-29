package racingcar;

public class GameMachine {

    void playRacingGame() {
        Output.printCarNameInputRequest();
        String[] carNames = Input.getCarName();
        Output.printTryNumberInputRequest();
        int tryNumber = Input.getTryNumber();
        RacingGame racingGame = new RacingGame();
        racingGame.createCars(carNames);
        Output.printResultTitle();
        for (int times = 0; times < tryNumber; times++) {
            racingGame.moveCars();
            Output.printRacingMap(racingGame.getCurrentStatus());
        }
        Output.printWinners(racingGame.getWinner());
    }
}
