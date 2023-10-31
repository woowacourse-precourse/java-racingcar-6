package racingcar.controller;

import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final InputValidation inputValidation;

    public CarController() {
        inputView = new InputView();
        outputView = new OutputView();
        carService = new CarService();
        inputValidation = new InputValidation();
    }


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

    public void getRoundRaceResult() {
        outputView.printRoundRaceResult(carService.createRoundRaceResult());
    }

    public void getWinner() {
        outputView.printWinnerResult(carService.createWinner(outputView.initWinnerResult()));
    }
}
