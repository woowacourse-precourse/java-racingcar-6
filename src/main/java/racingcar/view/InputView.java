package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputRacingCarNameValidator;
import racingcar.validator.InputTryCountValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final OutputView outputView;
    private final InputPreprocessor preprocessor;
    private final InputRacingCarNameValidator racingCarNameValidator;
    private final InputTryCountValidator tryCountValidator;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
        this.preprocessor = new InputPreprocessor();
        this.racingCarNameValidator = new InputRacingCarNameValidator();
        this.tryCountValidator = new InputTryCountValidator();
    }

    public List<String> inputRacingCarNames() {
        outputView.printRacingCarInputMessage();
        String input = Console.readLine();

        String[] racingCarNames = preprocessor.splitInputByComma(input); // ','에 따른 분리
        List<String> racingCarNamesList = new ArrayList<>();

        for (String racingCarName : racingCarNames) {
            racingCarName = preprocessor.trimInput(racingCarName); // 공백 제거

            racingCarNameValidator.validate(racingCarName); // 예외처리

            racingCarNamesList.add(racingCarName);
        }

        return racingCarNamesList;
    }

    public int inputTryCount() {
        outputView.printTryCountInputMessage();
        String input = preprocessor.trimInput(Console.readLine());

        return tryCountValidator.validateAndConvert(input);
    }
}
