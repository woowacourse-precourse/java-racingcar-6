package racingcar.controller;

import static racingcar.enumType.message.InputMessage.GET_TRY_COUNT_MESSAGE;
import static racingcar.enumType.message.InputMessage.SAVE_CAR_NAMES_MESSAGE;
import static racingcar.enumType.message.OutputMessage.RESULT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;
import racingcar.validation.InputValidation;

public class CarController {

    private final CarService carService = new CarService();
    private final InputValidation inputValidation = new InputValidation();

    public void save() {
        System.out.println(SAVE_CAR_NAMES_MESSAGE.getValue());
        String input = Console.readLine();
        inputValidation.validateCarNames(input);
        List<String> carNames = stringToCollection(input);
        carService.save(carNames);
    }

    private List<String> stringToCollection(String input) {
        return Stream.of(input.split(","))
                .toList();
    }

    public int getRaceCount() {
        System.out.println(GET_TRY_COUNT_MESSAGE.getValue());
        String attemptInput = Console.readLine();
        inputValidation.validateAttemptInput(attemptInput);
        int raceCount = Integer.parseInt(attemptInput);
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
        System.out.println(carService.createWinner());
    }
}
