package racingcar.handler;

import java.util.List;
import racingcar.view.input.InputView;

public class InputHandler {
    private final InputConvertor inputConvertor;
    private final InputValidator inputValidator;
    private final InputView inputView;

    public InputHandler(InputConvertor inputConvertor, InputValidator inputValidator, InputView inputView) {
        this.inputConvertor = inputConvertor;
        this.inputValidator = inputValidator;
        this.inputView = inputView;
    }

    public List<String> handleCarNamesInput() {
        String carNames = inputView.readCarNames();
        inputValidator.validateCarName(carNames);
        return inputConvertor.splitByComma(carNames);
    }

    public int handleRaceTimeInput() {
        String raceTime = inputView.readRaceTime();
        inputValidator.validateNumericInput(raceTime);
        return inputConvertor.convertToInt(raceTime);
    }
}
