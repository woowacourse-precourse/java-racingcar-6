package racingcar.model;

public final class Car {
    private final String name;
    private final int progress;

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car from(String name) {
        return new Car(name, 0);
    }

    public Car move(int randomNumber) {
        if(isMoved(randomNumber)) {
            return new Car(this.name, this.progress + 1);
        }
        return new Car(this.name, this.progress);
    }

    private boolean isMoved(int number) {
        return number >= 4;
    }
}
