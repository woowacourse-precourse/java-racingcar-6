package racingcar.model;

import static racingcar.constant.RaceConfig.DELIMITER_WHEN_WINNER_IS_PLURAL;
import static racingcar.constant.RaceConfig.STEP_FORWARD_SPACE_COUNT;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.dto.RaceResultTexts;
import racingcar.util.StepForwardValidator;
import racingcar.util.StringFormatter;

public final class CarsPosition {
    private final Map<String, Integer> carsPosition;

    private CarsPosition(Map<String, Integer> position) {
        this.carsPosition = position;
    }

    public static CarsPosition createPositionWithRacingCars(RacingCars racingCars) {
        return new CarsPosition(racingCars.createInitPosition());
    }

    public void race() {
        for (String key : carsPosition.keySet()) {
            if (StepForwardValidator.isCarStepForward()) {
                int position = carsPosition.get(key);
                carsPosition.put(key, position + STEP_FORWARD_SPACE_COUNT);
            }
        }
    }

    public RaceResultTexts getEachRaceResult() {
        List<String> eachResults = carsPosition.keySet()
                .stream()
                .map(key ->
                        StringFormatter.raceResultFormat(key, carsPosition.get(key)))
                .toList();
        return new RaceResultTexts(eachResults);
    }

    public String getWinner() {
        int maxValue = Collections.max(carsPosition.values());
        return StringFormatter.winnerFormat(getWinnerWithMaxValue(maxValue));
    }

    private String getWinnerWithMaxValue(int maxValue) {
        return carsPosition.keySet()
                .stream()
                .filter(name -> carsPosition.get(name).equals(maxValue))
                .collect(Collectors.joining(DELIMITER_WHEN_WINNER_IS_PLURAL));
    }
}
