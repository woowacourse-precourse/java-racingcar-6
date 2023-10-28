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

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
