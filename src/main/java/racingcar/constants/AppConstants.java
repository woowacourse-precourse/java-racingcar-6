package racingcar.constants;

public final class AppConstants {
    // 시스템 상수
    public static final int NAME_LENGTH_LIMIT = 5;
    public static final int RANDOM_BEGIN_RANGE = 0;
    public static final int RANDOM_END_RANGE = 9;
    public static final int FORWARD_CONDITION = 4;
    public static final String INPUT_DELIMITER = ",";
    public static final String POSITION_PROGRESS_BAR = "-";

    // 게임 출력 메시지
    public static final String MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MSG_INPUT_GAME_ROUND = "시도할 회수는 몇회인가요?";
    public static final String MSG_GAME_START = "\n실행 결과";
    public static final String MSG_FINAL_WINNER = "최종 우승자 : ";

    // 에러 출력 메시지
    public static final String ERR_NAME_CANNOT_BE_BLANK = "이름을 공백으로 설정할 수 없습니다.";
    public static final String ERR_PLEASE_ENTER_NAME_VALUE = "값을 입력해 주세요.";
    public static final String ERR_INVALID_NAME_LENGTH = "이름은 5자 이하로 입력하실 수 있습니다.";
    public static final String ERR_DUPLICATE_NAME_EXISTS = "중복된 이름이 존재합니다.";
    public static final String ERR_ROUND_CANNOT_BE_BLANK = "횟수를 공백으로 설정할 수 없습니다.";
    public static final String ERR_INVALID_ROUND_NUMBER = "횟수는 숫자로 입력되어야 합니다.";
    public static final String ERR_INVALID_ROUND_LOWER = "1 이상의 값을 입력해 주세요";

    private AppConstants() {}
}