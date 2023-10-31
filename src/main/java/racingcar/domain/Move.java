package racingcar.domain;

public class Move {

    private String position;

    private int distance;

    protected Move() {
        this.position = "";
    }

    protected String getPosition() {
        return position;
    }

    protected int getDistance() {
        return distance;
    }

    protected void addMove() {
        this.distance++;
        this.position += "-";
    }
}
