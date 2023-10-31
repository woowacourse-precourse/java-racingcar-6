package racingcar.exception;

import java.util.List;

public class InputCarException {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    private static final String NUMBER_OF_CAR_EXCEPTION_MESSAGE = "2개 이상의 자동차의 이름을 입력해주세요.";
    public static void nameLengthException(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE + " Car Name : " + name);
        }
    }

    public static void numberOfCarException(List<String> nameList) {
        if (nameList.size() < 2) {
            throw new IllegalArgumentException(NUMBER_OF_CAR_EXCEPTION_MESSAGE + " Name List : " + nameList);
        }
    }
}