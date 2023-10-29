package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    public static final int FINAL_ROUND_INDEX = 1;
    private final List<RacingRoundResult> racingRoundResults = new ArrayList<>();

    public void addResult(RacingRoundResult racingRoundResult) {
        this.racingRoundResults.add(racingRoundResult);
    }

    public List<RacingRoundResult> getRacingRoundResults() {
        return this.racingRoundResults.stream()
                .map(racingRoundResult -> new RacingRoundResult(racingRoundResult.getCarInfoList()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getFinalWinners() {
        return this.racingRoundResults.get(racingRoundResults.size() - FINAL_ROUND_INDEX).getWinners();
    }
}
