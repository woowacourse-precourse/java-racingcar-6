package racingcar;

public class Car {

    private String name;
    private int move;

    public Car(String name) {
        this.name = validateNameLength(name);
        this.move = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMove() {
        return this.move;
    }

    public void plusMove() {
        this.move++;
    }

    private String validateNameLength(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
        return name;
    }
}