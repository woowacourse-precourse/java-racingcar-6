package racingcar.validator;

import java.util.List;

public class EmptyNameValidator implements Validator {
    @Override
    public boolean isValid(List<String> carNameList) {
        return carNameList.contains("");
    }
}
