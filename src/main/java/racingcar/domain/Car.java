package racingcar.domain;

public class Car {
    String name;
    String currentPosition;
    public Car(String name) {
        this.name = name;
        currentPosition="";
    }
    public String getName() {
        return name;
    }
    public String getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
}