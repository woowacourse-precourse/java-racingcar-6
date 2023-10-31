package racingcar.utility;

public final class Constants {
    private Constants(){} //생성자를 private로 지정하여 인스턴스 생성 막기

    //숫자 관련 상수
    public static final int NAME_LENGTH_LIMIT = 5;

    //예외처리 정규표현식 패턴
    public static final String IMPROPER_COMMA_POSITION_PATTERN = "^(,.*|.*,,.*|.*,)$"; //문자열 처음 또는 끝에서 comma가 나오거나 문자열 내에서 2번 연속 나오는 경우
    public static final String VAILD_RACING_COUNT_PATTERN = "^[1-9]\\d*$";
}
