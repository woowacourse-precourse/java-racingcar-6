package racingcar;

import java.util.regex.Pattern;

/**
 * 게임 세부 정보
 */
public class GameDetail {

    public static final String CAR_SEPARATOR = ",";

    public static final int MIN_CAR_COUNT = 1;

    public static final int CAR_NAME_MIN_LENGTH = 1;

    public static final int CAR_NAME_MAX_LENGTH = 5;

    public static final Pattern CAR_NAME_PATTERN = Pattern.compile(".*[a-zA-Z가-힣]+.*");

    public static final String MOVE_MARK = "-";

    public static final int MOVE_THRESHOLD = 4;

}
