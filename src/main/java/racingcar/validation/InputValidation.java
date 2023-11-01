package racingcar.validation;

import java.util.Arrays;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;
import racingcar.exception.GlobalExceptionHandler;

public class InputValidation {
    private static final String STRING_HAS_KOREAN_OR_ENGLISH = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]*$";
    private static final String STRING_HAS_COMMA_SPLITIER = ",";

    public static void checkCarNamesOverMax(String inputValue) {
        String[] strings = inputValue.split(",");
        Arrays.stream(strings).forEach(carName -> {
            if (carName.length() > 5) {
                GlobalExceptionHandler.handleCustomException(
                        new CustomException(ErrorCode.CAR_NAME_OVER_FIVE_LETTERS));
            }
        });
    }

    public static void checkCarNamesHasBlank(String inputValue) {
        if (inputValue.equals(" ") || inputValue.isEmpty()) {
            GlobalExceptionHandler.handleCustomException(
                    new CustomException(ErrorCode.CAR_NAME_IS_BLANK));
        }
    }

    public static void checkTrialNumber(int trialNum) {
        if (trialNum <= 0) {
            GlobalExceptionHandler.handleCustomException(new CustomException(ErrorCode.TRIAL_NUMBER_LESS_THAN_ZERO));
        }
    }
}
