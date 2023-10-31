package racingcar.racer;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.RacerValidator;

public class RacerRegistry<T extends Racer> {

    private final List<T> racers = new ArrayList<>();

    public void addAll(List<? extends T> racers) {
        RacerValidator.validateRacerSize(racers);
        RacerValidator.validateDuplicatedName(racers);

        this.racers.addAll(racers);
    }

    public List<T> getRacers() {
        return racers;
    }
}
