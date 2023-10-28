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

    public void start() {
        play();
    }

    private void play() {

        String[] carNames = readNameInput();
        int round = readRoundInput();
        List<Car> cars = generateCars(carNames,round);

        racingView.displayResultMessage(ResultMessage.RACING_RESULT);
        List<String> results = racingModel.proceed(cars);
        racingView.displayWinnerMessage(results);
    }

    private String[] readNameInput() {
        racingView.displayMessage(RacingMessage.ASK_FOR_CAR_NAME);
        String inputName = racingView.readInput();
        return getUserInputName(inputName);
    }

    private int readRoundInput() {
        racingView.displayMessage(RacingMessage.ASK_FOR_ROUNDS);
        String inputRound = racingView.readInput();
        return getUserInputNumber(inputRound);
    }

    private List<Car> generateCars(String[] carNames, int round) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName,0,0,round,0,new ArrayList<>()));
        }
        return cars;
    }

    private String[] getUserInputName(String inputName) {
        isValidNameFormat(inputName);
        return Arrays.stream(inputName.split(","))
                                    .map(String::trim)
                                    .distinct()
                                    .peek(Validator::isValidLength)
                    .toArray(String[]::new);
    }

    private int getUserInputNumber(String inputNumber) {
        isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
