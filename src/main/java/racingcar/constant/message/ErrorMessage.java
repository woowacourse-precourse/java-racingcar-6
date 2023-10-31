package racingcar.constant.message;

import racingcar.constant.Rule;

public class ErrorMessage {

    public static final String INVALID_LENGTH = String.format("이름의 길이는 %s 이상 %s 이하여야 합니다.",
            Rule.MIN_LENGTH, Rule.MAX_LENGTH);
    public static final String BLANK_SPACE = "이름은 공백이 아니어야 합니다.";
    public static final String NO_PARTICIPANT = "참가자가 없습니다.";
    public static final String INVALID_TYPE = "잘못된 타입입니다.";
    public static final String INVALID_RANGE = "잘못된 범위입니다.";
    public static final String DUPLICATE_NAME = "중복된 이름입니다.";

    private ErrorMessage() {
    }
}
