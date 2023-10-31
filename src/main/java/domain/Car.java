package domain;

public class Car {

    private final String name;
    private Progress progress;

    public Car(String name) {
        this.name = name;
        this.progress = new Progress();
    }

    public void moveAhead() {
        this.progress = this.progress.addValue();
    }

    public RaceResult generateResult(Car car) {
        int currentProgress = car.getProgress().getValue();
        String currentName = car.getName();

        return new RaceResult(currentProgress, currentName);
    }

    public String getName() {
        return this.name;
    }

    public Progress getProgress() {
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
