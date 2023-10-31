package racingcar.collaborator.race;

import racingcar.generic.RacerProgress;
import racingcar.io.Randoms;

public class Racer {

    private final String name;
    private Integer mileage;

    public Racer(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public void drive() {
        if (4 <= Randoms.getSingleNumber()) {
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
