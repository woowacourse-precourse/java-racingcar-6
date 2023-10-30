package racingcar;

public class GameMachine {

    void playRacingGame() {
        RacingGame racingGame = new RacingGame();
        RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
        Output.printCarNameInputRequest();
        String[] carNames = Input.getCarName();
        racingGame.createCars(carNames);
        Output.printTryNumberInputRequest();
        int tryNumber = Input.getTryNumber();
        Output.printResultTitle();
        for (int times = 0; times < tryNumber; times++) {
            racingGame.moveCars(randomNumberMaker);
            Output.printRacingMap(racingGame.getCurrentStatus());
        }
        Output.printWinners(racingGame.getWinner());
    }
}
