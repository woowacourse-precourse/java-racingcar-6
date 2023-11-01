package racingcar.domain;

public final class Validate {
    public static void NameLengthLimit(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 5자리 이하만 가능합니다.");
        }
    }

}
