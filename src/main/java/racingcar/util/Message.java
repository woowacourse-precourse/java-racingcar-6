package racingcar.util;

import static racingcar.util.GameNumber.NAME_LENGTH;

public final class Message {
    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_PLAY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String OUTPUT_PLAY_RESULT = "실행 결과";
    public static final String OUTPUT_WINNER = "최종 우승자";
    public static final String MOVE_RESULT = "-";
    public static final String NAME_LIMIT_LENGTH = "이름은 " + NAME_LENGTH + "자리 이하만 가능";
    public static final String NAME_NO_DISTINCT = "이름은 중복될 수 없습니다";
    public static final String NAME_MUST_SIZE = "한 대 이상의 자동차가 있어야 합니다.";
    public static final String NAME_NO_WHITESPACE = "공백은 이름이 될 수 없습니다.";
    public static final String COUNT_MUST_INT = "횟수는 정수만 입력 가능합니다.";
    public static final String COUNT_MUST_POSITIVE_INT = "횟수는 양의 정수만 입력 가능합니다.";
}
