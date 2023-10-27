package racingcar.model;

public class Car {
    private CarName name;
    private int distance; // TODO : 원시 값 포장 대상

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public CarName getName() {
        return name;
    }

    public void addDistance(int dice, int forward) {
        if (dice >= forward) {
            distance++;
        }
    }

    public String getDistanceLine() {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(
                stringBuilder.append(getName().getRawName()).append(" : ").append("-".repeat(Math.max(0, this.distance))));
    }

    public Integer getDistance() {
        return distance;
    }
}
