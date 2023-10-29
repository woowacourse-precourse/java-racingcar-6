package racingcar.validator;

import java.util.List;

public class NamesCountValidator implements Validator<List<String>> {
    private static final String NAMES_COUNT_EXCEPTION_MESSAGE = "2개 이상의 자동차의 이름을 입력해 주십시오.";

    @Override
    public void validate(List<String> carNames) {
        if (carNames.size() <= 1) {
            throwException(NAMES_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
