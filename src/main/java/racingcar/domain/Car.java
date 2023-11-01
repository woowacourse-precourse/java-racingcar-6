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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
