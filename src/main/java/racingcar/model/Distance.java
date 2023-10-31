package racingcar.model;

public class Distance {

    private String distance;

    public void setDistance(String distance) {
        this.distance += distance;
    }

    public String getDistance() {
        return this.distance;
    }

    public void Distance() {
        this.distance = "";
    }
}
