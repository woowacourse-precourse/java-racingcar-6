package racingcar.domain;

import java.util.Objects;

public class CarName {
    private final int MAX_lENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (name.length() > MAX_lENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
