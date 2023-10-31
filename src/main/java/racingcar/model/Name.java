package racingcar.model;

import racingcar.dto.NameDto;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Name(final String name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(final String name) {
        if (MAX_NAME_SIZE < name.length()) {
            throw new IllegalArgumentException("[Error] 이름 크기는 5이하여야 합니다.");
        }
    }

    public NameDto toDto() {
        return new NameDto(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
