package racingcar;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public boolean canGoForward() {
        int randomNumber = randomNumberGenerator.getNumber();
        if (randomNumber > 4) {
            return true;
        }
        return false;
    }

    public void setCars(List<String> carName) {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = inputHandler.getCarNames();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

    }


    public void startGame() {
        outputHandler.printStartMessages();


        outputHandler.printAskRounds();
        int numberOfRounds = inputHandler.getNumberOfRound();

        for (int round = 0; numberOfRounds > round; round++) {

        }
    }
}
