package racingcar.util;

/**
 * 이 유틸리티 클래스에는 레이싱 카 게임 전반에 걸쳐 사용되는 게임 관련 상수가 저장된다.
 * 여기에는 자동차 이름 입력, 이동 횟수, 난수 생성과 관련된 상수가 포함된다.
 * 초기 위치, 출력 포맷과 관련된 상수를 포함한다.
 */
public class GameConstants {
    // 자동차 이름 입력
    /** 자동차 이름의 최소 길이 */
    public static final int MINIMUM_CAR_NAME_LENGTH = 1;

    /** 자동차 이름의 최대 길이 */
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    /** 자동차 이름 입력에 사용될 구분값의 한글 단어 */
    public static final String CAR_NAME_DELIMITER_KOR = "쉼표";

    /** 자동차 이름 입력에 사용될 구분값 */
    public static final String CAR_NAME_DELIMITER = ",";

    // 이동 횟수 입력
    /** 0 값을 나타내는 상수 */
    public static final int ZERO = 0;

    /** 허용되는 최대 이동 횟수 */
    public static final int MAXIMUM_MOVE_COUNT = 2147483647;

    // 랜덤 생성
    /** 랜덤 수 생성을 위한 최솟값 */
    public static final int MINIMUM_GENERATED_NUM = 0;

    /** 랜덤 수 생성을 위한 최댓값 */
    public static final int MAXIMUM_GENERATED_NUM = 9;

    /** 전진 여부를 결정하는 기준값 */
    public static final int STANDARD_MOVEMENT = 4;

    // 초기 위치
    /** 자동차들의 초기 위치 */
    public static final int INITIAL_POSITION = 0;

    // 출력 토큰
    /** 자동차의 위치를 나타내는데 사용되는 토큰 */
    public static final String OUTPUT_TOKEN = "-";
}
