package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int DRIVE_POSSIBLE = 4;
    private final String name;
    private Integer movedCount;

    private Car(final String name) {
        this.name = name;
        this.movedCount = 0;
    }

    public static Car make(final String name) {
        return new Car(name);
    }

    public CarStatus moveOrStop(int randomValue) {
        if(canMove(randomValue)) movedCount++;
        return new CarStatus(getName(), movedCount);
    }

    public String getName() {
        return name;
    }

    public Integer getMovedCount() {
        return movedCount;
    }

    @Override
    public int compareTo(Car cmpCar) {
        return cmpCar.getMovedCount() - this.getMovedCount();
    }

    private boolean canMove(int randomValue) {
        return randomValue >= DRIVE_POSSIBLE;
    }
}
