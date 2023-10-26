package racingcar.Model;

public class CarModel {

    private final String name;
    private int forwardDistance;

    public CarModel(String name) {

        this.name = name;
        this.forwardDistance = 0;
    }

    public String getName() {

        return name;
    }

    public int getForwardDistance() {

        return forwardDistance;
    }

    public void setForwardDistance(int forwardDistance) {
        this.forwardDistance = forwardDistance;
    }

}
