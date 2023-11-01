package racingcar.Entity;

public abstract class Racer {
    private final String name;
    private final Mover mover;

    protected Racer(String name, Mover mover) {
        this.name = name;
        this.mover = mover;
    }

    abstract void run();

    String getName() {
        return this.name;
    }

    int getLocation() {
        return mover.getLocation();
    }

    Mover getMover() {
        return this.mover;
    }
}
