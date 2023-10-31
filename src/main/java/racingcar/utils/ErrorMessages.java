package racingcar.utils;

import static racingcar.utils.Constants.MAX_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NUMBER_OF_CARS;
import static racingcar.utils.Constants.MIN_NUMBER_OF_ROUNDS;

public class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String WRONG_NUMBER_OF_CARS_MESSAGE = MIN_NUMBER_OF_CARS + "대 이상의 차량을 입력하세요.";
    public static final String NOT_DISTINCT_NAMES_MESSAGE = "중복되지 않는 이름들을 입력하세요.";
    public static final String WRONG_NAME_LENGTH_MESSAGE =
            MIN_NAME_LENGTH + "자 이상, " + MAX_NAME_LENGTH + "자이하의 이름을 입력하세요.(각 이름은 쉼표(,)로 구분해야합니다.)";
    public static final String NOT_POSITIVE_INTEGER_MESSAGE = "음수가 아닌 숫자를 입력하세요.(숫자 사이 공백 불가)";
    public static final String NOT_NATURAL_NUMBER_MESSAGE = "시도 횟수는 " + MIN_NUMBER_OF_ROUNDS + "이상인 자연수를 입력해야합니다.";

}
