package racingcar.utils;

public class Validater {

    public static void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 해야합니다.");
        }

        if(name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }
}
