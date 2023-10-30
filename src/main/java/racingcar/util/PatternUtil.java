package racingcar.util;

/**
 * 유효성 검사에 필요한 정규 표현식을 정의한 util 클래스 입니다.
 */
public abstract class PatternUtil {
        /**
         * 양수만 입력할 수 있는 규칙입니다.
         */
        public static final String ONLY_POSITIVE_NUMBER_PATTERN = "^[0-9]\\d*$";
}
