package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validator {
    /**
     * 입력 값 검증 함수
     * 입력: String(사용자의 경주 자동차 이름 입력값), int(입력값의 종류, 0일 경우 String, 1일 경우 Long)
     * 출력: boolean(정상적으로 경주 자동차 이름이 배정됐을 경우 true)
     */
    public boolean validate(String string, int type) {
        // 경주자동차 이름을 지정하는 입력값일 경우
        if (type == 1) {
            if (!isSplitByComma(string))
                return false;

            if (!isValidLength(string.split(",")))
                return false;

        }else { // 시도 회수를 나타내는 입력값일 경우
            if (!isValidNumber(string))
                return false;
        }

        return true;
    }

    /**
     * 자동차 이름 분리 가능여부 검증 함수
     * 입력: String(사용자의 경주 자동차 이름 입력값)
     * 출력: boolean(',' 기준으로 정상적으로 분리될 경우 true)
     */
    private boolean isSplitByComma(String string) {
        IllegalArgumentException exception = new IllegalArgumentException();
        // pobi,,woni와 같은 경우일 경우
        if (string.contains(",,"))
            throw exception;

        // ,만 입력했을 경우
        if (string.strip().equals(","))
            throw exception;

        // pobi,나 pobi와 같이 하나의 자동차 이름만 입력했을경우
        if (Arrays.asList(string.strip().split(",")).size() < 2)
            throw exception;
    }

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
