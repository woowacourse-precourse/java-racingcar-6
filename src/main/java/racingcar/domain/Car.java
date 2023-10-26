package racingcar.domain;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        String distance = "";
        for (int i = 0; i < position; i++) {
            distance += "-";
        }
        return name + " : " + distance;
    }
}
