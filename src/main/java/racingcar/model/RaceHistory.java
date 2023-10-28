package racingcar.model;

import static racingcar.model.ExceptionMessage.EMPTY_RACE_HISTORY_EXCEPTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private static final int LAST_ROUND_OFFSET = 1;

    private final List<CarGroup> raceStages;

    private RaceHistory(List<CarGroup> raceStages) {
        validateEmpty(raceStages);
        this.raceStages = new ArrayList<>(raceStages);
    }

    private void validateEmpty(List<CarGroup> raceStages) {
        if (raceStages.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_RACE_HISTORY_EXCEPTION_MESSAGE);
        }
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
