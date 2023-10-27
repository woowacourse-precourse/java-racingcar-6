package racingcar.domain;

public class CarDistanceMessage {

    private static final String SPLIT = " : ";
    private static final String ROAD = "-";
    private final String message;

    public CarDistanceMessage(String name, Integer distance) {
        message = name + SPLIT + ROAD.repeat(distance);
    }

    @Override
    public String toString() {
        return message;
    }

}
