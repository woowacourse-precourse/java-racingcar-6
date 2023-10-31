package racingcar.manager.view;

import java.util.List;

public class CarViewValidation {
    private static int CAR_NAME_LIMIT = 5;

    public boolean greaterThanFiveLetter(List<String> carNames){
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_LIMIT) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicated(List<String> carNames){
        return carNames.size() != carNames.stream().distinct().count();
    }
}
