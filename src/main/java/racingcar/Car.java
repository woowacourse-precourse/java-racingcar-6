package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
