package racingcar.exception;

import java.util.List;

public interface InputErrorException {
    void checkUserInputValidate(List<String> checkStringList);
}
