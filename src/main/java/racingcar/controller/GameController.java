package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.CarNameParser;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TotalRoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private List<String> carNames;
    private int totalRound;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        init();
        process();
        Console.close();
    }

    private void init() {
        initializeCars();
        initializeTotalRound();
    }

    private void initializeCars() {
        initializeCarNames();
        cars = Cars.create(carNames);
    }

    private void initializeCarNames() {
        String carNamesInput = readCarNamesFromUser();
        carNames = CarNameParser.parse(carNamesInput);
    }

    private String readCarNamesFromUser() {
        String input = inputView.readCarNames();
        CarNameValidator.validateCarNamesInput(input);
        return input;
    }

    private void initializeTotalRound() {
        String input = inputView.readTotalRound();
        totalRound = TotalRoundValidator.validateTotalRound(input);
    }

    private void process() {
        outputView.printStartResultMessage();
        processRounds();
        printWinners();
    }

    public void processRounds() {
        for (int round = 0; round < totalRound; round++) {
            processRound();
        }
    }

    public void processRound() {
        cars.play();
        List<Integer> positions = cars.provideRoundResult();
        outputView.printRoundResult(carNames, positions);
    }

    private void printWinners() {
        List<Car> winners = cars.determineWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        outputView.printWinners(winnerNames);
    }
}
