package racingcar.service;

public class Distance {

    private final Integer distance;
    private final static String DISTANCE_EXPRESSION = "-";

    public Distance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return this.distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_EXPRESSION);
        }
        return sb.toString();
    }
}
