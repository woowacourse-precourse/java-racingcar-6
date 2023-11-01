package racingcar.Domain;

import java.util.Objects;

public class Car {
    private String name;
    private Long position;

    public Car(String name) {
        this.name = name;
        this.position = 0L;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car otherCar = (Car) obj;
        return Objects.equals(name, otherCar.name) &&
                Objects.equals(position, otherCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
