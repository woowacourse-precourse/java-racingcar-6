package racingcar;
public class Car {
    private String name;
    private String distance;

    public String carString() {
        return new String(this.name + " : " + this.distance);
    }

    public void addDistance() {
        distance += "-";
    }

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

}
