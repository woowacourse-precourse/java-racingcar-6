package racingcar.validator;

import racingcar.constant.ExceptionMessage;

import java.util.List;

public class NameDuplicateValidator implements Validator<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        if (hasDuplicateName(carNames)) {
            throwException(ExceptionMessage.NAME_DUPLICATION_EXCEPTION_MESSAGE.get());
        }
    }

    private boolean hasDuplicateName(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
