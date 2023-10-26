package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Config;
import racingcar.views.OutputView;

public class Car {

    private String name;

    private String position;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.position = "";
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void tryAddPosition() {
        int randomNumber = Randoms.pickNumberInRange(Config.BEGIN_RANGE, Config.END_RANGE);
        if (randomNumber >= Config.MOVING_FORWORD) {
            this.position += "-";
            this.distance++;
        }
    }

    public void carPositionPrint() {
        OutputView.racingCarResultPrint(this.name, this.position);
    }

    public boolean carEqualsMaxDistance(int distance) {
        return this.distance == distance;
    }

}
