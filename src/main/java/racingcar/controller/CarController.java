package racingcar.controller;

import static racingcar.constant.MessageConst.GET_TRY_COUNT_MESSAGE;
import static racingcar.constant.MessageConst.RESULT_MESSAGE;
import static racingcar.constant.MessageConst.SAVE_CAR_NAMES_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;
import racingcar.validation.InputValidation;

public class CarController {

    private final CarService carService = new CarService();
    private final InputValidation inputValidation = new InputValidation();

    public void save() {
        System.out.println(SAVE_CAR_NAMES_MESSAGE);
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
        System.out.println(GET_TRY_COUNT_MESSAGE);
        String attemptInput = Console.readLine();
        inputValidation.validateAttemptInput(attemptInput);
        int raceCount = Integer.parseInt(attemptInput);
        System.out.println(RESULT_MESSAGE);
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
