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
    private final InputValidator validator = new InputValidator();
    private Cars cars;

    public void run() {

        cars = new Cars(createCarList());
        int times = readTimes();

        outputView.printResultMessage();
        for (int i = 0; i < times; i++) {
            cars.roundLevelMove();
            outputView.printResult(cars.getCarList());
        }

        outputView.printWinner(cars.findWinner());

    }

    public List<Car> createCarList() {

        List<String> carNames = inputView.readCarNames();

        carNames.forEach(validator::validateName);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int readTimes() {
        int times = inputView.readTimes();

        validator.validateTimes(times);

        return times;
    }


}
