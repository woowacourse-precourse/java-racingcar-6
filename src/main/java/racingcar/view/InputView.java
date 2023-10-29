package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputRacingCarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final OutputView outputView;
    private final InputRacingCarNameValidator nameValidator;
    private final InputPreprocessor preprocessor;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
        this.nameValidator = new InputRacingCarNameValidator();
        this.preprocessor = new InputPreprocessor();
    }

    public List<String> inputRacingCarNames() {
        outputView.printRacingCarInputMessage();
        String input = Console.readLine();

        String[] racingCarNames = preprocessor.splitInputByComma(input); // ','에 따른 분리
        List<String> racingCarNamesList = new ArrayList<>();

        for (String racingCarName : racingCarNames) {
            racingCarName = preprocessor.trimInput(racingCarName); // 공백 제거

            nameValidator.validate(racingCarName); // 예외처리

            racingCarNamesList.add(racingCarName);
        }

        return racingCarNamesList;
    }
}
