package domain;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car otherCar = (Car) o;

        return this.name.equals(otherCar.name);
    }

    @Override
    public int hashCode() {
        if (name == null) {
           return 0;
        }
        return name.hashCode();
    }
}
