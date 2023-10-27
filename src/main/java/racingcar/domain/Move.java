package racingcar.domain;

public class Move {

    private String position;

    private int distance;

    public Move() {
        this.position = "";
    }

    public String getPosition() {
        return position;
    }

    public int getDistance() {
        return distance;
    }

    public void addMove() {
        this.distance++;
        this.position += "-";
    }
}
