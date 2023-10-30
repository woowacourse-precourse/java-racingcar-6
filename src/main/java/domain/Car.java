package domain;

public class Car {

    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public Car moveAhead() {
        return new Car(this.name, this.progress+1);
    }

    public RaceResult generateResult(Car car) {
        int currentProgress = car.getProgress();
        String currentName = car.getName();

        return new RaceResult(currentProgress, currentName);
    }

    private String getName() {
        return this.name;
    }

    private int getProgress() {
        return this.progress;
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
