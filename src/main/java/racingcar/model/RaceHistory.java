package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private static final int LAST_ROUND_OFFSET = 1;

    private final List<CarGroup> raceStages;

    private RaceHistory(List<CarGroup> raceStages) {
        this.raceStages = new ArrayList<>(raceStages);
    }

    public static RaceHistory from(List<CarGroup> raceRounds) {
        return new RaceHistory(raceRounds);
    }

    public CarWinners findFinalStageWinners() {
        CarGroup finalRaceStage = getFinalStage();
        return finalRaceStage.findWinners();
    }

    private CarGroup getFinalStage() {
        int finalStageIndex = getFinalStageIndex();
        return raceStages.get(finalStageIndex);
    }

    private int getFinalStageIndex() {
        return raceStages.size() - LAST_ROUND_OFFSET;
    }

    public List<CarGroup> getRaceStages() {
        return new ArrayList<>(raceStages);
    }
}
