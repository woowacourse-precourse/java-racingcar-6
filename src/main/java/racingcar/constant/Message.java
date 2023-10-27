package racingcar.constant;

public final class Message {
    public static final String DELIMITER = ",";

    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;
    public static final int FORWARD_ABLE_NUMBER = 4;

    public static String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    public static String RACE_RESULT = "실행 결과";
    public static String WINNER_NAME = "최종 우승자 : ";

    public static final String EXCEPTION_DELIMITER_TYPE = "구분자는 쉼표(,)만 사용 가능합니다.";
    public static final String EXCEPTION_ROUND_TYPE = "숫자만 입력해주세요.";
    public static final String EXCEPTION_INVALID_CAR_NAME_LENGTH = "자동차의 이름은 1 ~ 5자 사이로 지어주세요.";
    public static final String EXCEPTION_DUPLICATE_CAR_NAME = "중복된 자동차 이름은 사용할 수 없습니다";
}
