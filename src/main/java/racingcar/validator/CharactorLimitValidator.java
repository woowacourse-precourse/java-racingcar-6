package racingcar.validator;

import java.util.List;

public class CharactorLimitValidator implements Validator {
    @Override
    public boolean isValid(List<String> carNameList) {
        return carNameList.stream().anyMatch(str -> str.length() > 5);
    }
}
