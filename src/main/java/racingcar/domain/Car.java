package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Config;
import racingcar.views.OutputView;

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

    public int getDistance() {
        return move.getDistance();
    }

    public void tryAddMove() {
        int randomNumber = Randoms.pickNumberInRange(Config.BEGIN_RANGE, Config.END_RANGE);
        if (randomNumber >= Config.MOVING_FORWORD) {
            this.move.addMove();
        }
    }

    public void carPositionPrint() {
        OutputView.racingCarResultPrint(this.name, this.move.getPosition());
    }

    public boolean carEqualsMaxDistance(int distance) {
        return this.move.getDistance() == distance;
    }

}
