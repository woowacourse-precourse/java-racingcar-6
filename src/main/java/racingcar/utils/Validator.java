package racingcar.utils;

public class Validator {

    public static void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 해야합니다.");
        }

        if(name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }
    public static void validateNumberOfMove(int move) {
        if(move <= 0) {
            throw new IllegalArgumentException("이동 횟수는 양수여야 합니다.");
        }
    }
}
