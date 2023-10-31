package racingcar;

import java.util.regex.Pattern;

public class Constants {
	public static final int NAME_SIZE = 5;
	public static final int MIN_RANDOM_NUM = 0;
	public static final int MAX_RANDOM_NUM = 9;
	public static final int MOVE_NUM = 4;


	public static final String DELIMITER = ",";
	public static final String DELIMITER_WINNER = ", ";
	public static final String ROUND_RESULT = "\n실행 결과";
	public static final String ROUND_RESULT_DELIMITER = " : ";
	public static final String DASH = "-";

	public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
	public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$");


	public static final String INPUT_START = String.format("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)", DELIMITER);
	public static final String TRY_NUM_START = "시도할 회수는 몇회인가요?";
	public static final String WINNER_RESULT = "최종 우승자 : ";
}
