package racingcar.constant;

import static racingcar.constant.ConstantNumber.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.ConstantNumber.MAX_TRIAL_COUNT;

public abstract class ErrorMessage {
    public static final String CAR_NAME_IS_LONGER = String.format("이름의 길이가 %d자를 초과합니다.", MAX_CAR_NAME_LENGTH);
    public static final String ENTER_ONLY_NATURAL_NUMBER = "자연수만 입력해주세요. 음수도 불가능 합니다.";
    public static final String CAR_NAME_IS_EMPTY = "이름을 올바르게 입력해주세요. 쉼표를 연달아 입력하지 마세요.";
    public static final String ENTER_PROPER_RANGE_NUMBER = String.format("1부터 %d까지의 숫자만 입력해 주세요", MAX_TRIAL_COUNT);
    public static final String CAR_NAME_IS_DUPLICATED = "이름이 중복된 자동차가 존재합니다.";
}
