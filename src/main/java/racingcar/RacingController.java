package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

        Cars cars = new Cars(createCarList());
        int numRound = readNumRound();
        inputView.close();

        outputView.printResultMessage();
        for (int round = 0; round < numRound; round++) {
            cars.roundLevelMove();
            outputView.printResult(cars.getCarList());
        }

        outputView.printWinner(cars.findWinner());

    }

    public List<Car> createCarList() {

        List<String> carNames = inputView.readCarNames();

        carNames.forEach(InputValidator::validateName);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int readNumRound() {
        int numRound = inputView.readNumRound();

        InputValidator.validateNumRound(numRound);

        return numRound;
    }


}
