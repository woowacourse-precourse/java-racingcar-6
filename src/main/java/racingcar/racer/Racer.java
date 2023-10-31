package racingcar.racer;

import java.util.Objects;

public abstract class Racer implements Raceable {
    protected final String name;
    protected int position;

    protected Racer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Racer racer = (Racer) o;

        return Objects.equals(name, racer.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
