package racingcar.model;

public class Car implements Comparable<Car> {
    private final DriveStrategy driveStrategy;
    private final String name;
    private int position;


    public Car(DriveStrategy driveStrategy, String name, int position) {
        this.driveStrategy = driveStrategy;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += 1;
    }

    public boolean canMove() {
        return driveStrategy.determineDistance();
    }

    public StringBuilder showPosition() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb;
    }


    public boolean isSamePosition(Car other) {
        return other.position == this.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
