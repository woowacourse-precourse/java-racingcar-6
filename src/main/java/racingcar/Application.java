package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = RacingGame.setupCars();
        int moves = InputView.getNumberOfMoves();

        RacingGame game = new RacingGame(cars);
        game.race(moves);
        ResultView.displayWinners(cars);
    }
}
