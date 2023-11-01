package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.validator.Validator;


public class InputView {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Validator duplicateNameValidator;
    private final Validator characterLimitValidator;
    private final Validator emptyNameValidator;


    public InputView(Validator duplicateNameValidator, Validator characterLimitValidator,
                     Validator emptyNameValidator) {
        this.duplicateNameValidator = duplicateNameValidator;
        this.characterLimitValidator = characterLimitValidator;
        this.emptyNameValidator = emptyNameValidator;
    }

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return readLine();
    }

    public List<String> parseCarNames(String input) {
        List<String> carNameList = List.of(input.split(","));
        validateCarNames(carNameList);
        return carNameList;
    }

    public String inputMoveCount() {
        System.out.println(INPUT_MOVE_COUNT_MESSAGE);
        return readLine();
    }

    public int parseMoveCount(String input) {
        validateMoveCount(input);
        return Integer.parseInt(input);
    }

    public void validateMoveCount(String input) {
        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException("error: 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private boolean isPositiveInteger(String input) {
        try {
            int num = Integer.parseInt(input);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void validateCarNames(List<String> carNameList) {
        if (duplicateNameValidator.isValid(carNameList)) {
            throw new IllegalArgumentException("error: 중복된 이름이 입력되었습니다.");
        }
        if (characterLimitValidator.isValid(carNameList)) {
            throw new IllegalArgumentException("error: 글자수가 초과된 이름이 입력되었습니다.");
        }
        if (emptyNameValidator.isValid(carNameList)) {
            throw new IllegalArgumentException("error: 구분자 사이에 입력되지 않은 이름이 있습니다.");
        }
    }
}
