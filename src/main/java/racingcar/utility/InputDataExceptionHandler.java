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
}
