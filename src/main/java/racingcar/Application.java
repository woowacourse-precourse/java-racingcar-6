package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Input;
import racingcar.domain.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        final Output output = new Output();
        final Input input = new Input();

        output.printInputCarNameMessage();
        List<CarName> carNames = input.getCarNames();
        Cars cars = new Cars(carNames);
        output.printInputGameCountMessage();
        int gameCount = input.getGameCount();
        output.printResultMessage();

        CarRacingGame carRacingGame = new CarRacingGame(output);
        carRacingGame.start(gameCount, cars);
        output.printWinner(cars);
    }
}