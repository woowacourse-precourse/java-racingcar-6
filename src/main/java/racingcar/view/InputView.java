package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.validator.InputValidator;
import racingcar.util.StringParser;

public class InputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_NUMBER_OF_ROUNDS = "시도할 회수는 몇회인가요?";

    private final InputValidator<String> roundNumberValidator;
    private final InputValidator<List<String>> carNamesValidator;

    public InputView(InputValidator<String> roundNumberValidator, InputValidator<List<String>> carNamesValidator) {
        this.roundNumberValidator = roundNumberValidator;
        this.carNamesValidator = carNamesValidator;
    }

    public List<String> readCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String carNamesString = Console.readLine();
        List<String> carNames = StringParser.parseToList(carNamesString);
        carNamesValidator.validate(carNames);
        return carNames;
    }

    public RoundCount readNumberOfRounds() {
        System.out.println(REQUEST_NUMBER_OF_ROUNDS);
        return new RoundCount(Console.readLine());
    }
}
