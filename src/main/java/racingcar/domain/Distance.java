package racingcar.domain;

public class Distance {

    private static final String initString = "";
    private static final int initDistance = 0;
    private static final String moveIndicator = "-";
    private static final int moveDistance = 1;

    private String distanceString;
    private Integer distance;

    public Distance() {
        this.distanceString = initString;
        this.distance = initDistance;
    }

    public void printDistance() {
        System.out.println(this.distanceString);
    }

    public void increaseDistance() {
        this.distanceString += moveIndicator;
        this.distance += moveDistance;
    }

    public int compareTo(Distance otherDistance) {
        return otherDistance.distance - this.distance;
    }
}
