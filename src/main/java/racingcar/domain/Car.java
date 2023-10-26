package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.views.OutputView;

public class Car {

    private String name;

    private StringBuilder distance = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void tryAddDistance() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance.append("-");
        }
    }

    public void carDistancePrint() {
        OutputView.racingCarResultPrint(this.name, this.distance.toString());
    }

}
