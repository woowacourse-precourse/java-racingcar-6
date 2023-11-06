package racingcar;

import static racingcar.RacingGame.*;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.startGame();

        Car[] cars = racingGame.getInput();
        getAttemptingNum();

        moveCars(cars, attemptingNum);
        printRacingGameResults(cars);

        String winners = findWinners(cars);
        printWinnerPhrase();
        System.out.println(winners);
    }
}
