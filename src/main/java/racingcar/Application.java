package racingcar;

import racingcar.view.ViewInput;
import racingcar.view.ViewOutput;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static ViewInput viewInput = new ViewInput();
    private static ViewOutput viewOutput = new ViewOutput();

    public static void main(String[] args) {

        List<String> carNames = viewInput.getCarNames();
        int numberOfRounds = viewInput.getNumberOfRounds();

        List<Car> cars = new ArrayList<>();

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        Game game = new Game();

        System.out.println();
        game.playAllRounds(cars, numberOfRounds);

        System.out.println();
        viewOutput.printWinner(game.findWinner(cars));
    }
}
