package racingcar.collaborator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.collaborator.generic.RacerProgress;

public class Racer {

    private String name;
    private Integer mileage;

    public Racer(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public void drive() {
        if (4 <= Randoms.pickNumberInRange(0, 9)) {
            mileage++;
        }
    }

    public RacerProgress getProgress() {
        return new RacerProgress(name, mileage);
    }

    public String getName() {
        return name;
    }
}
