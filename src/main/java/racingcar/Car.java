package racingcar;

public class Car {

    private String name;
    private int score;

    public Car(String name) {
        nameCheck(name);
        this.name = name;
    }

    public void nameCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}