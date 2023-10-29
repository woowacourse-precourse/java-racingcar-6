package racingcar;

public class Car {
    String name;
    int pos = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        pos++;
    }
}
