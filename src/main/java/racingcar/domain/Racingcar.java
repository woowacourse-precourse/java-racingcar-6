package racingcar.domain;

public class Racingcar {
    private String name;
    private int movingforward;

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
