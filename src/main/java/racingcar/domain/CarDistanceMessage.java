package racingcar.domain;

public class CarDistanceMessage {

    public static final String SPLIT = " : ";
    public static final String ROAD = "-";
    private final String name;
    private final Integer distance;

    public CarDistanceMessage(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + SPLIT + ROAD.repeat(distance);
    }

}
