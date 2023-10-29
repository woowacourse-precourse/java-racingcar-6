package racingcar;

public class Car {

    String name;
    int meter;

    public Car(String name) {
        this.name = name;
        this.meter = 0;
    }

    public void moveOrNot(int randomNumber) {
        if(randomNumber >= 4) {
            meter++;
        }
    }
}
