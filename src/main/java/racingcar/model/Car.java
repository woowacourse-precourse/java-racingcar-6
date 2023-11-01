package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int DRIVE_POSSIBLE = 4;
    private final CarName name;
    private Integer movedCnt;

    private Car(final String name) {
        this.name = new CarName(name);
        this.movedCnt = 0;
    }

    public static Car make(final String name) {
        return new Car(name);
    }

    public CarStatus moveOrStop(int randomValue) {
        if(canMove(randomValue))
            movedCnt++;
        return new CarStatus(getName(), movedCnt);
    }

    public String getName() {
        return name.toString();
    }

    public Integer getMovedCount() {
        return movedCnt;
    }

    @Override
    public int compareTo(Car cmpCar) {
        return cmpCar.getMovedCount() - this.getMovedCount();
    }

    private boolean canMove(int randomValue) {
        return randomValue >= DRIVE_POSSIBLE;
    }
}
