package racingcar;

public class Validation {
    public static void validateNameLengthNotOver(String name, int limit) {
        if (name.length() > limit) {
            throw new IllegalArgumentException("이름의 길이는 " + limit + "글자를 넘으면 안됩니다.");
        }
    }
}
