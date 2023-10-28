package racingcar.utility;


import java.util.List;

public class InputDataExceptionHandler {
    private static final int MAX_CAR_NAME_SIZE = 5;
    public static void validateCarNames(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateTotalRounds(String totalRounds) {
        if(totalRounds.equals("0")) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < totalRounds.length(); i++) {
            char isNum = totalRounds.charAt(i);
            if(isNum < '0' || isNum > '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
