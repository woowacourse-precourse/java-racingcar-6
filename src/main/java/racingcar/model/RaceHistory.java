package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private static final String EMPTY_RACE_STAGES_EXCEPTION = "경주 스테이지 기록이 비어있으면 경주 기록을 생성할 수 없습니다.";
    private static final int LAST_ROUND_OFFSET = 1;

    private final List<RaceStage> raceStages;

    private RaceHistory(List<RaceStage> raceStages) {
        validateEmpty(raceStages);
        this.raceStages = new ArrayList<>(raceStages);
    }

    private void validateEmpty(List<RaceStage> raceStages) {
        if (raceStages.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_RACE_STAGES_EXCEPTION);
        }
    }

    public static RaceHistory from(List<RaceStage> raceStages) {
        return new RaceHistory(raceStages);
    }

    public Winners findFinalStageWinners() {
        RaceStage finalRaceStage = getFinalStage();
        return finalRaceStage.findWinners();
    }

    private RaceStage getFinalStage() {
        validateEmpty(raceStages);
        int finalStageIndex = getFinalStageIndex();
        return raceStages.get(finalStageIndex);
    }

    private int getFinalStageIndex() {
        return raceStages.size() - LAST_ROUND_OFFSET;
    }

    public List<RaceStage> getRaceStages() {
        return new ArrayList<>(raceStages);
    }
}
