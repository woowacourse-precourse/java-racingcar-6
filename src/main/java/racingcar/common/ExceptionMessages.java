package racingcar.common;

public class ExceptionMessages {

    // 자동차 이름 입력 예외
    public static final String INVALID_NAME_LENGTH_EXCEPTION = "이름은 공백을 제거하여 최소 1자 이상 5자 이하만 가능합니다.";
    public static final String NO_COMMA_EXCEPTION = "이름을 쉼표(,)로 구분해야 합니다. 또한, 최소 2대 이상의 자동차가 필요합니다.";
    public static final String DUPLICATE_CAR_EXCEPTION = "동일한 이름으로 경주 게임을 진행할 수 없습니다.";
    public static final String INVALID_FORMAT_INPUT_EXCEPTION = "입력 형식은 다음과 같습니다. 예시) name1,name2,name3";

    // 시도 횟수 입력 예
    public static final String NOT_NUMERIC_INPUT_EXCEPTION = "숫자를 입력해야 합니다.";
    public static final String SMALLER_THAN_ZERO_EXCEPTION = "0보다 큰 숫자를 입력해야 합니다.";

}
