package racingcar.collaborator.generic;

import java.util.List;

public record RaceTotalProgress(List<LapProgress> recorded) {

    public RaceTotalProgress(List<LapProgress> recorded) {
        this.recorded = List.copyOf(recorded);
    }

}
