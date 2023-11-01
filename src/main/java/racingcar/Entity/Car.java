package racingcar.Entity;

public class Car extends Racer {

    private Car(String name, int location) {
        super(name, new LinearMover(location));
    }

    public static Car create(String name, int location) {
        return new Car(name, location);
    }

    @Override
    public void run() {
        super.getMover().moveForward();
    }
}