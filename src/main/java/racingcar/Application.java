package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Input;
import racingcar.domain.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Output output = new Output();
        Input input = new Input();

        output.printInputCarNameMessage();
        List<String> carNames = input.getCarNames();
        output.printInputGameCountMessage();
        int gameCount = input.getGameCount();
        Cars cars = new Cars(carNames);
        output.printResultMessage();

        for (int i = 0; i < gameCount; i++) {
            List<Car> moveResult = cars.moveAllCar();
            output.printNameAndDistance(moveResult);
        }
        output.printWinner(cars);
    }
}
