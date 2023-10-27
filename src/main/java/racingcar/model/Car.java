package racingcar.model;

public final class Car {
    private final String name;
    private final int progress;

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car of(String name, int progress) {
        return new Car(name, progress);
    }

    public Car move(int randomNumber) {
        if(isMoved(randomNumber)) {
            return new Car(this.name, this.progress + 1);
        }
        return this;
    }

    private boolean isMoved(int number) {
        return number >= 4;
    }
}
