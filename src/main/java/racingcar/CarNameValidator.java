package racingcar;


import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;

/**
 * 잘못된 예외 케이스
 * "1. faaaef,eerrwea,aa" -> 이름이 5글자가 넘음
 */
public class CarNameValidator {

    public static void validate(String input) {
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_IS_LONGER);
            }
        }
    }
}
