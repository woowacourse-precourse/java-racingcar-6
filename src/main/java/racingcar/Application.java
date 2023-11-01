package racingcar;

import racingcar.domain.*;

public class Application {
    public static void main(String[] args) {

        final Output output = new Output();
        final Input input = new Input();

        output.printInputCarNameMessage();
        CarNames carNames = input.getCarNames();
        Cars cars = new Cars(carNames);
        output.printInputGameCountMessage();
        GameCount gameCount = input.getGameCount();
        output.printResultMessage();

        CarRacingGame carRacingGame = new CarRacingGame(output);
        carRacingGame.start(gameCount, cars);
        output.printWinner(cars);
    }
}