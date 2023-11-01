package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
