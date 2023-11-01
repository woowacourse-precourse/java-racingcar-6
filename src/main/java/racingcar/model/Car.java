package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int MIN_RANDOM_VALUE_TO_MOVE = 4;
    private final Name name;
    private Integer movedCount;

    private Car(final String name) {
        this.name = new Name(name);
        this.movedCount = 0;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public Result moveOrStop(int randomValue) {
        if(canMove(randomValue)) movedCount++;
        return new Result(getName(), movedCount);
    }

    public String getName() {
        return name.toString();
    }

    public Integer getMovedCount() {
        return movedCount;
    }

    @Override
    public int compareTo(Car cmpCar) {
        return cmpCar.getMovedCount()- this.getMovedCount();
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MIN_RANDOM_VALUE_TO_MOVE;
    }
}
