package racingcar.model;

public class Distance {
    private int distance;

    /**
     * 거리는 0으로 설정됨
     */
    public Distance() {
        this.distance = 0;
    }

    /**
     * 주어진 음수가 아닌 정수로 거리를 생성한다.
     * @param nonNegativeInteger 음이 아닌 정수
     * @throws IllegalArgumentException nonNegativeInteger < 0
     */
    public Distance(int nonNegativeInteger) throws IllegalArgumentException {
        if (nonNegativeInteger < 0) {
            throw new IllegalArgumentException();
        }

        this.distance = nonNegativeInteger;
    }
}