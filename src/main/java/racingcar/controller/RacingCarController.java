package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.InputPreprocessor;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.validator.InputRacingCarNameValidator;
import racingcar.validator.InputTryCountValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final InputPreprocessor preprocessor;
    private final InputRacingCarNameValidator racingCarNameValidator;
    private final InputTryCountValidator tryCountValidator;

    public RacingCarController() {
        this.inputView = new InputView(new OutputView());
        this.preprocessor = new InputPreprocessor();
        this.racingCarNameValidator = new InputRacingCarNameValidator();
        this.tryCountValidator = new InputTryCountValidator();
    }

    public void play() {
        List<RacingCar> racingCars = setupRacingCars();
        int tryCount = getValidatedTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        game.start();
    }

    private List<RacingCar> setupRacingCars() {
        List<String> racingCarNames = getValidatedRacingCarNames();
        return createRacingCars(racingCarNames);
    }

    private List<String> getValidatedRacingCarNames() {
        String input = receiveRacingCarNamesInput();
        return processAndValidateRacingCarNames(input);
    }

    private String receiveRacingCarNamesInput() {
        return inputView.receiveRacingCarNamesInput();
    }

    private List<String> processAndValidateRacingCarNames(String input) {
        String[] racingCarNames = splitInputByComma(input);
        return validateAndCollectRacingCarNames(racingCarNames);
    }

    private String[] splitInputByComma(String input) {
        return preprocessor.splitInputByComma(input);
    }

    private List<String> validateAndCollectRacingCarNames(String[] racingCarNames) {
        List<String> racingCarNamesList = new ArrayList<>();
        for (String racingCarName : racingCarNames) {
            racingCarName = trimInput(racingCarName);
            racingCarNameValidator.validate(racingCarName);
            racingCarNamesList.add(racingCarName);
        }
        return racingCarNamesList;
    }

    private String trimInput(String input) {
        return preprocessor.trimInput(input);
    }

    private int getValidatedTryCount() {
        String input = trimInput(receiveTryCountInput());
        return tryCountValidator.validateAndConvert(input);
    }

    private String receiveTryCountInput() {
        return inputView.receiveTryCountInput();
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }
}
