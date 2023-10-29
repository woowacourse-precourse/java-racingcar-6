package racingcar.controller;

import static racingcar.utils.Validator.isNumber;
import static racingcar.utils.Validator.isValidNameFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.model.RacingModel;
import racingcar.utils.Validator;
import racingcar.view.RacingView;
import racingcar.view.enums.RacingMessage;
import racingcar.view.enums.ResultMessage;

public class RacingController {
    private RacingModel racingModel;
    private RacingView racingView;

    public RacingController(RacingModel racingModel, RacingView racingView) {
        this.racingModel = racingModel;
        this.racingView = racingView;
    }

    public void play() {

        String[] carNames = readCarNames();
        int round = readRoundNumber();

        List<Car> cars = racingModel.generateCars(carNames,round);
        List<String> results = racingModel.proceed(cars);

        racingView.displayResult(results);
    }

    private String[] readCarNames() {
        racingView.displayMessage(RacingMessage.ASK_FOR_CAR_NAME);
        String inputName = racingView.readInput();
        return processCarNames(inputName);
    }

    private int readRoundNumber() {
        racingView.displayMessage(RacingMessage.ASK_FOR_ROUNDS);
        String inputRound = racingView.readInput();
        return processRoundNumber(inputRound);
    }

    private String[] processCarNames(String inputName) {
        isValidNameFormat(inputName);
        return Arrays.stream(inputName.split(","))
                .map(String::trim)
                .distinct()
                .peek(Validator::isValidLength)
                .toArray(String[]::new);
    }

    private int processRoundNumber(String inputNumber) {
        isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

}
