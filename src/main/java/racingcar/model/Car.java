package racingcar.model;

public class Car {
    String name;
    int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Move() {
        position++;
    }

    public String GetName() {
        return name;
    }

    public int GetPosition() {
        return position;
    }
}
