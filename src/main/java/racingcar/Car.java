package racingcar;

public class Car {
    final String name;
    int location;

    public Car(String name) {
        this.name = name;
        this.location =0;
    }

    public void move(int going) {
        this.location += going;
    }

}
