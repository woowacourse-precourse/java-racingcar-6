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

        output.CarNameInputMessage();
        List<String> carNames = input.inputCarNames();
        output.gameCountInputMessage();
        int gameCount = input.inputGameCount();

        Cars cars = new Cars(carNames);
        output.resultMessage();

        for (int i = 0; i < gameCount; i++) {
            List<Car> moveResult = cars.move();
            output.printResult(moveResult);
        }

        output.printWinner();








    }
}
