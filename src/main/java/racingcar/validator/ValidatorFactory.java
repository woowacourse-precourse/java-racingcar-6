package racingcar.validator;

import java.util.List;

public class ValidatorFactory {
    // 입력된 자동차 이름 전체 문자열 검증
    public static Validator<String> forInputCarName() {
        return new InputCarNameValidator();
    }

    // 분리된 자동차 개별 이름 검증
    public static Validator<List<String>> forIndividualCarName() {
        return new IndividualCarNameValidator();
    }

    // 입력된 이동 시도 횟수 검증
    public static Validator<String> forAttemptCount() {
        return new AttemptCountValidator();
    }
}