package racingcar.controller;

import racingcar.domain.RacingCar;
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
        List<String> racingCarNames = getValidatedRacingCarNames();
        List<RacingCar> racingCars = createRacingCars(racingCarNames);
        int tryCount = getValidatedTryCount();

        // 게임 시작 로직
    }

    private List<String> getValidatedRacingCarNames() {
        String input = inputView.receiveRacingCarNamesInput();
        String[] racingCarNames = preprocessor.splitInputByComma(input);
        List<String> racingCarNamesList = new ArrayList<>();

        for (String racingCarName : racingCarNames) {
            racingCarName = preprocessor.trimInput(racingCarName);
            racingCarNameValidator.validate(racingCarName);
            racingCarNamesList.add(racingCarName);
        }

        return racingCarNamesList;
    }

    private int getValidatedTryCount() {
        String input = preprocessor.trimInput(inputView.receiveTryCountInput());
        return tryCountValidator.validateAndConvert(input);
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }
}
