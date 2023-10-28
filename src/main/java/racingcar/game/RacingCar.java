package racingcar.game;


import racingcar.model.Name;
import racingcar.model.Position;

public class RacingCar {

    private static final int MOVING_FORWARD = 4;
    private Name name;
    private Position position;

    public RacingCar(Name name) {
        this.name = name;
        this.position = Position.zero();
    }

    public RacingCar(Name name, Position position) {
        this.name = name;
        this.position = position;
    }


    /**
     * @param actionNumber 를 기준으로 자동차를 움직일지 말지 판단한다. 4이상인 경우 움직임
     */
    public void move(int actionNumber) {
        if (actionNumber < MOVING_FORWARD) {
            return;
        }

        position = position.move();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isSamePosition(RacingCar racingCar) {
        return position.equals(racingCar.position);
    }

    public int comparePosition(RacingCar racingCar) {
        return position.compareTo(racingCar.position);
    }
}
