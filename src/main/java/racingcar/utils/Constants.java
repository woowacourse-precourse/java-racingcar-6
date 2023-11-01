package racingcar.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final int MIN_STRENGTH = 0;
    public static final int MAX_STRENGTH = 9;
    public static final int NAME_SIZE = 5;
    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INSERT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String NAME_SIZE_MESSAGE = "이름은 다섯자 이하로 입력해야 합니다.";
    public static final String RIGHT_NAME_MESSAGE = "이름은 이름, 이름형식의 패턴을 지켜주세요.";
    public static final String SAME_NAME_MESSAGE = "이름은 모두 다르게 입력해주세요.";
    public static final String Right_Number_MESSAGE = "숫자를 입력해주세요.";
    public static final Pattern ROUND_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern NAME_STRING_PATTERN = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$");
}
