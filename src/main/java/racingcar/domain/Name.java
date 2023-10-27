package racingcar.domain;

import java.util.regex.Pattern;

public class Name {

    private static final Pattern ALPHABET_CHECK = Pattern.compile("^[a-zA-Z]*$");
    public static final int LIMIT_NAME_LENGTH = 5;

    private final String value;

    private Name(final String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    public static Name from(final String name) {
        NameValidator.validate(name);
        return new Name(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return value.equals(name1.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    private static class NameValidator {

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
}

