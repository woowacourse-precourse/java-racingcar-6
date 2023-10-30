package racingcar.domain;

public class Car implements Comparable{
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {

    }

    public String expressMoveDistance() {
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
