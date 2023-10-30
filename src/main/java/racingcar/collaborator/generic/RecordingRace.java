package racingcar.collaborator.generic;

import java.util.List;

public record RecordingRace(List<RaceProgress> recorded) {

    public RecordingRace(List<RaceProgress> recorded) {
        this.recorded = List.copyOf(recorded);
    }

}
