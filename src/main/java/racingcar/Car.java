package racingcar;

public class Car {
    String name;
    int state = 0;

    Car(String name) {
        this.name = name;
    }

    Car(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= 4) {
            state++;
        }
    }
}
