package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.converter.InputConverter;
import racingcar.domain.game.car.Cars;
import racingcar.util.InputValidator;

public class InputView {
    private final String INPUT_CAR_NAMES_MESSSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ALL_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private final InputValidator inputValidator;
    private final InputConverter inputConverter;

    public InputView(InputValidator inputValidator, InputConverter inputConverter) {
        this.inputValidator = inputValidator;
        this.inputConverter = inputConverter;
    }

    public Cars getCarsFromUserInput() {
        System.out.println(INPUT_CAR_NAMES_MESSSAGE);
        String input = readLine();
        inputValidator.validateInputFormat(input);
        inputValidator.validateNonEmpty(input);
        return inputConverter.convertStringToCars(input);
    }

    public int getTrialFromUserInput() {
        System.out.println(INPUT_ALL_ROUND_MESSAGE);
        String input = readLine();
        inputValidator.validateNumericString(input);
        return inputConverter.covertStringToInteger(input);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
