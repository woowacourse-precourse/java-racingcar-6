package racingcar.domain;

/**
 * 자동차 이름과 이동 거리를 가지고 있는 클래스
 */
public class Car {
    private String name;
    private int dist;

    public Car() {

    }

    public Car(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    public int getDist() {
        return dist;
    }
}
