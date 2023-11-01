package racingcar.Entity;

public class Car {
    private final String name;
    private final Mover mover;

    private Car(String name, int location) {
        this.name = name;
        this.mover = new LinearMover(location);
    }

    public static Car createCar(String name, int location) {
        return new Car(name, location);
    }

    public void run() {
        mover.moveForward();
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return mover.getLocation();
    }
}