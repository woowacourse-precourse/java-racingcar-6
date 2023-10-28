package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Input;
import racingcar.domain.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        final Output output = new Output();
        final Input input = new Input();

        output.printInputCarNameMessage();
        List<String> carNames = input.getCarNames();
        output.printInputGameCountMessage();
        int gameCount = input.getGameCount();
        Cars cars = new Cars(carNames);
        output.printResultMessage();

        CarRacingGame carRacingGame = new CarRacingGame(output);
        carRacingGame.start(gameCount, cars);
        output.printWinner(cars);
    }
}