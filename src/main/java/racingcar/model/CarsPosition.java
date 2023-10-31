package racingcar.model;

import static racingcar.constant.RaceConfig.CONVERTING_SIGNS;
import static racingcar.constant.RaceConfig.DELIMITER_WHEN_WINNER_IS_PLURAL;
import static racingcar.constant.RaceConfig.STEP_FORWARD_SPACE_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.StringFormatter;

public final class CarsPosition {
    private final Map<String, Integer> carsPosition;

    private CarsPosition(Map<String, Integer> position) {
        this.carsPosition = position;
    }

    public static CarsPosition createPositionWithRacingCars(RacingCars racingCars) {
        return new CarsPosition(racingCars.createInitPosition());
    }

    public RaceResultTexts getEachRaceResult() {
        List<String> result = new ArrayList<>();
        for (String key : carsPosition.keySet()) {
            checkStepForward(key);
            String signs = convertPositionToSigns(carsPosition.get(key));
            result.add(StringFormatter.raceResultFormat(key, signs));
        }
        return new RaceResultTexts(result);
    }

    private void checkStepForward(String key) {
        if (StepForwardValidator.isCarStepForward()) {
            int changedPosition = carsPosition.get(key) + STEP_FORWARD_SPACE_COUNT;
            carsPosition.put(key, changedPosition);
        }
    }

    private String convertPositionToSigns(int position) {
        return CONVERTING_SIGNS.repeat(position);
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
