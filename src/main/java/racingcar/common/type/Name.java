package racingcar.common.type;

import java.util.Objects;
import racingcar.common.validator.NameValidator;

public final class Name {
    private final String name;

    private Name(String name) {
        //입력 문자열 압뒤 공백 제거
        String trimmedName = name.trim();
        NameValidator.validate(trimmedName);
        this.name = trimmedName;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(getName(), name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
