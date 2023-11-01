package racingcar.dto;

import java.util.Objects;

public class NameLocationPair {
    private final String name;
    private final int location;

    public NameLocationPair(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NameLocationPair that = (NameLocationPair) o;
        return location == that.location && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
