package racingcar.domain;

public final class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        validateLength();
    }

    private void validateLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Error: 자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarName carName)) {
            return false;
        }

        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
