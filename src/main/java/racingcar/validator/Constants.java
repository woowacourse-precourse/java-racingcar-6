package racingcar.validator;

import java.util.regex.Pattern;

public class Constants {
    //정규 표현식 이용
    public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$");

    //예외처리 관련 문구
    public static final String CARNAME_WRONG_ERROR="자동차 이름 입력은 쉼표로 구분되어 있어야 하며, 공백을 포함하지 않아야 한다.";
    public static final String CARNAME_SIZE_ERROR="자동차 이름은 1~5자리의 문자로 이루어져야 한다.";
    public static final String CARNAME_DUPLICATE_ERROR="자동차 이름에 중복이 없어야 한다.";
    public static final String NUMBER_ERROR = "시고 횟수는 1번 이상의 숫자여야 한다.";

    public static final int STARTNUM =0;
    public static final int ENDNUM =9;
    public static final String DASH = "-";
    public static final String WINNER = "최종 우승자 : ";

    public static final String START_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String START_NUM_MESSAGE = "시도할 횟수는 몇회인가요?";
}
