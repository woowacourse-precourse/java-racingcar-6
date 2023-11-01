package racingcar.domain;

public class Car {
    private String name;
    private StringBuffer forwardDistance;

    public Car(String name) {
        this.name = name;
        this.forwardDistance = new StringBuffer("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringBuffer getForwardDistance() {
        return forwardDistance;
    }

    public void setForwardDistance(StringBuffer forwardDistance) {
        this.forwardDistance = forwardDistance;
    }

    public String status() {
        return this.name + " : " + this.forwardDistance;
    }

    public void forward() {
        this.forwardDistance.append("-");
    }
}
