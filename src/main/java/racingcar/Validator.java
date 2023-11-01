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
        if (type == 0) {
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
        // pobi,,woni와 같은 경우일 경우
        if (string.contains(",,"))
            throw new IllegalArgumentException();

        // ,만 입력했을 경우
        if (string.strip().equals(","))
            throw new IllegalArgumentException();

        // ,pobi,woni 혹은 pobi,woni,와 같이 입력될 경우
        if (string.startsWith(",") || string.endsWith(","))
            throw new IllegalArgumentException();

        // pobi,나 pobi와 같이 하나의 자동차 이름만 입력했을경우
        if (Arrays.asList(string.strip().split(",")).size() < 2)
            throw new IllegalArgumentException();

        return true;
    }

    /**
     * 자동차 이름 검증 기능
     * 입력: String[](경주 자동차 이름 배열)
     * 출력: boolean(경주 자동차의 이름이 1자 이상 5자 이하일 경우 true)
     */
    private boolean isValidLength(String[] string) {
        for (String carName : string) {
            // 자동차 이름이 공백을 포함할 경우
            if (carName.contains(" "))
                throw new IllegalArgumentException();

            // 자동차 이름이 6자 이상일 경우
            if (carName.length() > 5)
                throw new IllegalArgumentException();
        }

        return true;
    }

    /**
     * 시도 회수 검증 함수
     * 입력: String(사용자의 시도 회수 입력값)
     * 출력: boolean(시도 회수가 숫자이며 입력값과 똑같이 Long으로 변환된다면 true)
     */
    private boolean isValidNumber(String string) {
        Long number;
        try {
            number = Long.parseLong(string);
        } catch (NumberFormatException e) { // 숫자로 변환이 안될 경우
            throw new IllegalArgumentException();
        }

        // 변환한 숫자와 원본 문자열의 숫자가 같지 않을 경우
        if (!string.equals(number.toString()))
            throw new IllegalArgumentException();

        return true;
    }
}
