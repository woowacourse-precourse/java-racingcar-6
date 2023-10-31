package racingcar;

public class Car {
    public String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        distance ++;
    }

    public int getDistance() {
        return distance;
    }

    public void printForwardDistance() {

    }


}
