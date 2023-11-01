package racingcar.util.print.constants;

public abstract class RacingGameConstants {

    private RacingGameConstants() {
    }
    public static final int MIN_ADD_CAR = 1;
    public static final int MIN_CAR_NAME_LENGTH = 5;

    public static final int FROM_MIN_VALUE = 0;
    public static final int TO_MAX_VALUE = 9;
    public static final int MIN_VALUE_FOR_MOVE = 3;
    public static final String RACE_START_MESSAGE = "실행 결과";
    public static final String WINNER = "최종 우승자 : ";
    public static final String REQUEST_FOR_RACING_ROUNDS_MESSAGE = "시도할 회수는 몇회인가요";
    public static final String REQUEST_FOR_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

}
