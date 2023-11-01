package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racer.Racer;
import racingcar.validator.RacerValidator;

public class RacerRegistry<T extends Racer> {

    private final List<T> racers = new ArrayList<>();

    public void addAll(List<? extends T> racers) {
        RacerValidator.validateRacerSize(racers);
        RacerValidator.validateDuplicatedRacerName(racers);

        this.racers.addAll(racers);
    }

    public void clear() {
        racers.clear();
    }

    public List<T> getRacers() {
        return racers;
    }
}
