package racingcar.collaborator.race;

import racingcar.generic.RacerProgress;
import racingcar.io.Randoms;

public class Racer {

    private final String name;
    private Integer mileage;
    private Randoms randoms;

    public Racer(String name, Randoms randoms) {
        this.name = name;
        this.mileage = 0;
        this.randoms = randoms;
    }

    public void drive() {
        // TODO : 매직넘버 제거할 것
        if (4 <= randoms.getSingleNumber()) {
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
