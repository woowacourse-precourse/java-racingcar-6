package racingcar.domain;

public class Car {
    private String name;
    private String traveledDistance;

    public Car(String name) {
        this.name = name;
        this.traveledDistance = "";
    }

    public void moveForward() {
        traveledDistance += "-";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        stringBuilder.append(traveledDistance);
        return stringBuilder.toString();
    }
}
