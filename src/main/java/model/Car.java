package model;

public class Car {

    private final Name name;
    private final MovingCount movingCount;

    public Car(String name) {
        this.name = new Name(name);
        this.movingCount = new MovingCount();
    }

    public void increaseMovingCountIfGreater(int standardNumber, int randomNumber) {
        if (randomNumber > standardNumber) {
            this.movingCount.increase();
        }
    }

    public int getMovingCount() {
        return this.movingCount.getMovingCount();
    }
}
