package racingcar.entity;

public class Car {

    private String name;
    private int location = 0;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    private void goForward(){
        this.location += 1;
    }
}
