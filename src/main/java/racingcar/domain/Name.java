package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("이름은 1자 이상이어야 합니다.");
        }
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

    @Override
    public String toString() {
        return name;
    }
}
