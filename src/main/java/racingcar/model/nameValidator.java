package racingcar.model;

public class nameValidator {
    public static void namesException(String names){
        isNamesNull(names);
    }
    public static void isNamesNull(String names) {
        if (names.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해주세요");
    }
}
