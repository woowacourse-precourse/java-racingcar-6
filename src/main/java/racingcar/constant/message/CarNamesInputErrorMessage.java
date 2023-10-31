package racingcar.constant.message;

import racingcar.constant.GameConstant;

public class CarNamesInputErrorMessage {
    public static final String INPUT_IS_EMPTY = "입력값 오류 : 차 이름은 적어도 한 글자 이상이어야 합니다.";
    public static final String INPUT_DOES_NOT_CONTAIN_DELIMITER = "입력값 오류 : 최소 두 개 이상의 지동차를 입력해야 합니다.";
    public static final String INPUT_LENGTH_EXCEEDS_LIMIT =
            "입력값 오류 : 입력된 차 이름의 길이가 " + GameConstant.CAR_NAME_MAX_LENGTH + " 이상입니다.";
}