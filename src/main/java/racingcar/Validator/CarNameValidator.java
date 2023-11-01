package racingcar.Validator;

import java.util.List;

public interface CarNameValidator {

        void isValidLength(String carName);

        void hasWhiteSpace(String carName);

        void hasDuplicateName(List<String> carNames);
}
