package racingcar;

public class Car {

    private String name;
    private String distance = "";
    private int count = 0;


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance += distance;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

}
