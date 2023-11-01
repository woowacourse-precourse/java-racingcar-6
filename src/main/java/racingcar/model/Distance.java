package racingcar.model;

public class Distance implements Comparable<Distance>{
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

    /**
     * @return 증가한 경우 true, 그렇지 않은 경우 false
     */
    public boolean increaseByOne() {
        if (distance < Integer.MAX_VALUE) {
            distance += 1;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Distance o) {
        return this.distance - o.distance;
    }

    /**
     * @return ex. "-----"
     */
    @Override
    public String toString() {
        return "-".repeat(distance);
    }
}