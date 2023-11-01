package racingcar.exception;

import racingcar.GameDetail;

/**
 * 자동차 관련 예외 메시지
 */
public class CarExceptionMessage {

    public static final String UNDER_MIN_CAR_COUNT = String.format("%d대 이하의 자동차 입력값 포함", GameDetail.MIN_CAR_COUNT);

    public static final String OVERSIZE_CAR_NAME = String.format("%d~%d자가 아닌 자동차이름 입력값 포함", GameDetail.CAR_NAME_MIN_LENGTH, GameDetail.CAR_NAME_MAX_LENGTH);

    public static final String ONLY_SPECIAL_CHARACTER_CAR_NAME = "특수문자로만 구성된 자동차이름 입력값 포함";

    public static final String DUPLICATE_CAR_NAME = "중복된 자동차이름 입력값 포함";

}
