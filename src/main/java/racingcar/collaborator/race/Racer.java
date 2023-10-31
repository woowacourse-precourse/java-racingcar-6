package racingcar.collaborator.race;

import racingcar.generic.RacerProgress;
import racingcar.io.Randoms;

public class Racer {

    public static final int CRITERIA_FOR_MOVING_FORWARD = 4;
    private final String name;
    private final Randoms randoms;
    private Integer mileage;

    public Racer(String name, Randoms randoms) {
        this.name = name;
        this.mileage = 0;
        this.randoms = randoms;
    }

    public void drive() {
        if (CRITERIA_FOR_MOVING_FORWARD <= randoms.getSingleNumber()) {
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
