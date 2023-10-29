package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarDto;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.RandomNumberGenerator;
import racingcar.validation.NameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private Cars cars;

    private final RandomNumberGenerator randomNumberGenerator;
    private final RandomMoveStrategy randomMoveStrategy;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(RandomNumberGenerator randomNumberGenerator, RandomMoveStrategy randomMoveStrategy, InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
        this.randomMoveStrategy = randomMoveStrategy;
    }

    public void run() {
        initCars();
        outputView.requestRounds();
        int rounds = makeStringToNumber(inputView.getInput());
        playGame(rounds);
        List<Car> winners = cars.getWinners();
        outputView.announceWinner(winners);
    }

    private void initCars() {
        outputView.requestCarNames();
        String namesContainComma = inputView.getInput();
        NameValidator validator = new NameValidator(namesContainComma);
        validator.validateNames();
        List<Car> cars = Arrays.stream(namesContainComma.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(cars);
    }

    private void playGame(int rounds) {
        outputView.printExecutionResult();
        for (int i = 0; i < rounds; i++) {
            cars.moveAll(randomNumberGenerator, randomMoveStrategy);
            List<CarDto> carStatus = cars.getStatus();
            outputView.printCarStatus(carStatus);
        }
    }

    private int makeStringToNumber(String input) {
        return Integer.parseInt(input);
    }
}
