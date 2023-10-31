package racingcar.validator;


import static racingcar.constant.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;

/**
 * 잘못된 예외 케이스
 * "1. faaaef,eerrwea,aa" -> 이름이 5글자가 넘음
 * "2. "asdf,,,ds,," -> 이름이 없는 차들이 발생
 */
public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validate(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            name = name.trim();
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_IS_LONGER);
            }
            if (name.length() == 0) {
                throw new IllegalArgumentException(CAR_NAME_IS_EMPTY);
            }
        }
    }
}
