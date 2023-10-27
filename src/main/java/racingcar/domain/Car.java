package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Config;

public class Car {

    private String name;

    private Move move;

    public Car(String name) {
        this.name = name;
        this.move = new Move();
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return move.getDistance();
    }

    public String getMovePosition() {
        return move.getPosition();
    }

    public void tryAddMove() {
        int randomNumber = Randoms.pickNumberInRange(Config.BEGIN_RANGE, Config.END_RANGE);
        if (randomNumber >= Config.MOVING_FORWARD) {
            this.move.addMove();
        }
    }

    public boolean carEqualsMaxDistance(int distance) {
        return this.move.getDistance() == distance;
    }

}
