package racingcar.controller;

import racingcar.constant.format.Delimiter;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.InputConverter;
import racingcar.validation.NameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameInitializer {
    private final InputView inputView;
    private final OutputView outputView;

    public GameInitializer(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Cars initializeCars() {
        outputView.requestCarNames();
        String namesContainComma = inputView.getInput();

        NameValidator nameValidator = new NameValidator(namesContainComma);
        nameValidator.validateNames();

        List<Car> carList = Arrays.stream(namesContainComma.split(Delimiter.COMMA.getSymbol()))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    public int initializeRounds() {
        outputView.requestRounds();
        String roundsInput = inputView.getInput();
        return InputConverter.convertRoundStringToNumber(roundsInput);
    }
}
