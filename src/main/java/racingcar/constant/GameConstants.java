package racingcar.constant;

public class GameConstants {
    private GameConstants() {
    }


    public static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_NUMBER = "시도할 회수";
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 0;
    public static final String EXECUTION_RESULT = "실행 결과";
    public static final String SPACE = " ";
    public static final String COLONS = ":";
    public static final String COMMA = ",";
    public static final String DASH = "-";
    public static final String NULL = "";
    public static final String FINAL_WINNER = "최종 우승자";

    //예외처리
    public static final String NAME_IS_MORE_THAN_FIVE_LETTER = "[ERROR] 이름의 길이는 5글자 이하이어야 합니다. %s는 5글자를 넘습니다.";
    public static final String INPUT_SHOULD_NOT_BE_NULL = "[ERROR] 입력은 공백이면 안됩니다.";
    public static final String CAR_NAME_IS_DUPLICATED = "[ERROR] 자동차 이름은 중복되면 안됩니다.";

    public static final String CAR_NAMES_FORM_IS_WRONG = "[ERROR] 자동자이름들 형식이 잘못 됐습니다.";
    public static final String INPUT_IS_NOT_NUMBER = "[ERROR] 입력이 숫자가 아닙니다.";
    public static final String ATTEMPT_NUMBER_SHOULD_BE_MORE_THAN_ONE = "[ERROR] 입력시도는 한번 이상이어야 합니다. 지금 값은 %d입니다";
    public static final String RANDOM_NUMBER_RANGE_IS_OUT_OF_RANGE = "[ERROR] 랜덤 값은 0이상 9이하이어야 합니다. 지금 값은 %d입니다";

}
