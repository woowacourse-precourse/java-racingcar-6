package racingcar.domain;

public class Racingcar {
    private String name; // 자동차 이름
    private int movingforward; // 자동차 전진 거리

    public Racingcar(String name) {
        this.name = name;
        this.movingforward = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingforward() {
        return movingforward;
    }

    public void setMovingforward(int distance) {
        this.movingforward += distance;
    }

}
