package racingcar.domain;

public class Distance {

    private int distance;

    public Distance(int distance) {
        validateCarDistance(distance);
        this.distance = distance;
    }

    private void validateCarDistance(int carDistance) {
        validateCarDistanceIsMinus(carDistance);
    }

    public void validateCarDistanceIsMinus(int carDistance) {
        if (carDistance < 0) {
            throw new IllegalArgumentException("자동차 위치는 0 미만이 될 수 없습니다.");
        }
    }

    public void moveDistance() {
        distance++;
    }

    public int getValue() {
        return this.distance;
    }
}
