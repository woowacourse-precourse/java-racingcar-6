package racingcar;

public class Validator {
    /**
     * 입력 값 검증 함수
     * 입력: String(사용자의 경주 자동차 이름 입력값)
     * 출력: boolean(정상적으로 경주 자동차 이름이 배정됐을 경우 true)
     */
    public boolean validate(String string) {return true;}

    /**
     * 자동차 이름 분리 가능여부 검증 함수
     * 입력: String(사용자의 경주 자동차 이름 입력값)
     * 출력: boolean(',' 기준으로 정상적으로 분리될 경우 true)
     */
    private boolean isSplitedByComma(String string) {return true;}

    /**
     * 자동차 이름 길이 검증 기능
     * 입력: String[](경주 자동차 이름 배열)
     * 출력: boolean(경주 자동차의 이름이 1자 이상 5자 이하일 경우 true)
     */
    private boolean isValidLength(String[] string) {return true;}

    /**
     * 시도 회수 검증 기능
     * 입력: String(사용자의 시도 회수 입력값)
     * 출력: boolean(시도 회수가 Long의 최대 크기보다 작을 경우 true)
     */
    private boolean isValidNumber(String string) {return true;}
}
