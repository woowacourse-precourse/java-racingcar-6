package racingcar.model;

public class Car {

    private String name;
    private int position;


    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(name, 0);
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }


}
