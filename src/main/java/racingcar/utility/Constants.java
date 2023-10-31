package racingcar.utility;

public final class Constants {
    private Constants(){} //생성자를 private로 지정하여 인스턴스 생성 막기

    //숫자 관련 상수
    public static final int NAME_LENGTH_LIMIT = 5;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_REQUIRED_ADVANCEMENT = 4;

    //예외처리 정규표현식 패턴
    public static final String IMPROPER_COMMA_POSITION_PATTERN = "^(,.*|.*,,.*|.*,)$"; //문자열 처음 또는 끝에서 comma가 나오거나 문자열 내에서 2번 연속 나오는 경우
    public static final String VAILD_RACING_COUNT_PATTERN = "^[1-9]\\d*$";

    //출력 관련 상수
    public static final String CAR_NAME_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_COUNT_INPUT_PROMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String EXECUTION_RESULT = "\n실행 결과";


}
