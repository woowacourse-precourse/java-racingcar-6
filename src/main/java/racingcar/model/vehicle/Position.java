package racingcar.model.vehicle;

public class Position {
    private Integer position;
    public Position(Integer position) {
        this.position = position;
    }
    public Integer getPosition() {
        return position;
    }

    public Integer plusOne() {
        return ++position;
    }
    public Boolean isSame(Position givenPosition) {
        return givenPosition.getPosition().equals(position);
    }
}
