package racingcar.validate;

import java.util.List;

public class CarNamesValidation implements UserInputValidation<List<String>> {
    @Override
    public boolean validate(List<String> data) {
        if (data.size() >= 5) return false;
        for (String carName : data) {
            if (carName.length() >= 5) return false;
        }
        return true;
    }
}
