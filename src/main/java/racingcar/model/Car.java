package racingcar.model;

public class Car {
    private final CarName name;
    private Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance(0);
    }

    public CarName getName() {
        return name;
    }

    public void forward(int dice, int numberForForward) {
        if (dice >= numberForForward) {
            this.distance = distance.addDistance();
        }
    }

    public String getDistanceLine() {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(
                stringBuilder.append(getName().getRawName()).append(" : ").append("-".repeat(Math.max(0, this.distance.getDistance()))));
    }

    public Distance getDistance() {
        return distance;
    }
}
