package racingcar.validation;

import java.util.Arrays;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;
import racingcar.exception.GlobalExceptionHandler;

public class InputCarNameValidation {
    private static final String STRING_HAS_KOREAN_OR_ENGLISH = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]*$";
    private static final String STRING_HAS_COMMA_SPLITIER = ",";

    public static void checkCarNames(String inputValue) {
        String[] strings = inputValue.split(",");
        Arrays.stream(strings).forEach(carName -> {
            if (carName.length() > 5) {
                GlobalExceptionHandler.handleCustomException(
                        new CustomException(ErrorCode.CAR_NAME_WITHIN_FIVE_LETTERS));
            }
        });
    }
}
