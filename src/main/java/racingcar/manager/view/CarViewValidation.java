package racingcar.manager.view;

import java.util.List;

public class Validation {
    private static int CAR_NAME_LIMIT = 5;
    private static String CAR_NAME_SEPARATOR = ",";
    public boolean isNotSeparator(String carNames){
        return !carNames.contains(CAR_NAME_SEPARATOR);
    }

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
