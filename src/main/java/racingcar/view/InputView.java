package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.validator.Validator;


public class InputView {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final Validator duplicateNameValidator;
    private final Validator characterLimitValidator;
    private final Validator emptyNameValidator;


    public InputView(Validator duplicateNameValidator, Validator characterLimitValidator,
                     Validator emptyNameValidator) {
        this.duplicateNameValidator = duplicateNameValidator;
        this.characterLimitValidator = characterLimitValidator;
        this.emptyNameValidator = emptyNameValidator;
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        List<String> carNameList = List.of(readLine().split(","));
        validateCarNames(carNameList);
        return carNameList;
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
