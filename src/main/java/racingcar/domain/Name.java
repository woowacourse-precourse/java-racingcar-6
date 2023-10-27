package racingcar.domain;

import java.util.regex.Pattern;

public class Name {

    private static final Pattern ALPHABET_CHECK = Pattern.compile("^[a-zA-Z]*$");
    public static final int LIMIT_NAME_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Name from(final String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(final String name) {
        validateLength(name);
        validateCarNames(name);
    }

    private static void validateLength(final String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5글자를 넘길 수 없습니다.");
        }
    }

    private static void validateCarNames(final String name) {
        if (isNotAlphabet(name)) {
            throw new IllegalArgumentException("자동차 이름은 영문으로만 구성되어야 합니다.");
        }
    }

    private static boolean isNotAlphabet(final String carName) {
        return !ALPHABET_CHECK.matcher(carName)
                .matches();
    }
}

