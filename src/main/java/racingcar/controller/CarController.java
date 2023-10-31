package racingcar.controller;

import static racingcar.enumType.message.OutputMessage.RESULT_MESSAGE;
import static racingcar.enumType.message.OutputMessage.WINNER_MESSAGE;

import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;

public class CarController {

    private final InputView inputView = new InputView();
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
        int raceCount = Integer.parseInt(input);
        System.out.println(RESULT_MESSAGE.getValue());
        return raceCount;
    }

    public void forward() {
        carService.forward();
    }

    public void getRoundRaceResults() {
        System.out.println(carService.createRoundRaceResults());
    }

    public void getWinner() {
        StringBuilder winner = new StringBuilder();
        winner.append(WINNER_MESSAGE.getValue()).append(" : ");
        System.out.println(carService.createWinner(winner));
    }
}
