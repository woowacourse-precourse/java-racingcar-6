package racingcar.validator;

import java.util.List;

public class NameDuplicateValidator implements Validator<List<String>> {

    private static final String NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차의 이름은 중복되지 않게 입력해주십시오.";

    @Override
    public void validate(List<String> carNames) {
        if (hasDuplicateName(carNames)) {
            throwException(NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicateName(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
