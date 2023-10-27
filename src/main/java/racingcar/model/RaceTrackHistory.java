package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceTrackHistory {
    private final List<CarGroup> historySteps;

    private RaceTrackHistory(List<CarGroup> historySteps) {
        this.historySteps = new ArrayList<>(historySteps);
    }

    public static RaceTrackHistory from(List<CarGroup> carGroupHistory) {
        return new RaceTrackHistory(carGroupHistory);
    }

    public List<CarGroup> getHistorySteps() {
        return new ArrayList<>(historySteps);
    }
}
