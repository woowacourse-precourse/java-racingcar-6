package racingcar;

public class Car implements Comparable<Car> {
    final private String name;
    private int numberOfMove;

    public Car(String name) {
        if (isInvalidName(name))
            throw (new IllegalArgumentException("Invalid Argument"));
        this.name = name;
        this.numberOfMove = 0;
    }

    public Car(String name, int move) {
        if (isInvalidName(name))
            throw (new IllegalArgumentException("Invalid Argument"));
        this.name = name;
        this.numberOfMove = move;
    }

    private boolean isInvalidName(String name) {
        return name.isEmpty() || name.length() > 5;
    }

    public void moveFoward(int randomValue) {
        if (randomValue >= 4)
            numberOfMove++;
    }

    final public int getNumberOfMove() {
        return this.numberOfMove;
    }

    final public String getName() {
        return this.name;
    }

    public int compareTo(Car obj) {
        return this.numberOfMove - obj.numberOfMove;
    }
}
