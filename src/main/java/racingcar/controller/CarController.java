package racingcar.controller;

import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarService carService = new CarService();
    private final InputValidation inputValidation = new InputValidation();


    public void save() {
        String input = inputView.readConsole();
        inputValidation.validateCarNames(input);
        List<String> carNames = stringToCollection(input);
        carService.save(carNames);
    }

    private List<String> stringToCollection(String input) {
        return Stream.of(input.split(","))
                .toList();
    }

    public int getRaceCount() {
        String input = inputView.readConsoleRace();
        inputValidation.validateAttemptInput(input);
        return Integer.parseInt(input);
    }

    public void printStartRaceMessage() {
        outputView.printStartRaceMessage();
    }

    public void forward() {
        carService.forward();
    }

    public void getRoundRaceResults() {
        outputView.printRoundRaceResults(carService.createRoundRaceResults());
    }

    public void getWinner() {
        outputView.printWinnerResult(carService.createWinner(outputView.initWinnerResult()));
    }
}
