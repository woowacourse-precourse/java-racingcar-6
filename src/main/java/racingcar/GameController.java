package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public List<Car> setCars() {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = inputHandler.getCarNames();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void startGame() {
        outputHandler.printStartMessages();
        setCars();

        Race race = new Race(setCars());

        outputHandler.printAskRounds();
        int numberOfRounds = inputHandler.getNumberOfRound();
        outputHandler.printRunResult();

        for (int round = 0; numberOfRounds > round; round++) {
            race.runOneRound();
            outputHandler.printResults(race.getCars());
        }

        race.setWinners();
        outputHandler.printWinners(race.getWinners());
    }
}
