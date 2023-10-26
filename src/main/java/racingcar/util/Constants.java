package racingcar.util;

public class Constants {
    // InputRaceView Constants
    public static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACE_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    // OutputRaceView Constants
    public static final String RACE_RESULT_HEADER = "\n실행 결과";
    public static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    // Car Movement Constants
    public static final int RANDOM_THRESHOLD = 4;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    // Race Constants
    public static final int MIN_RANDOM_RANGE = 0;
    public static final int MAX_RANDOM_RANGE = 9;
}
