package racingcar.model;

import static racingcar.constant.RaceConfig.CONVERTING_SIGNS;
import static racingcar.constant.RaceConfig.DELIMITER_WHEN_WINNER_IS_PLURAL;
import static racingcar.constant.RaceConfig.LEAST_VALUE_TO_STEP_FORWARD;
import static racingcar.constant.RaceConfig.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constant.RaceConfig.MINIMUM_RANDOM_NUMBER;
import static racingcar.constant.RaceConfig.STEP_FORWARD_SPACE_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
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

    public String getEachRaceResult() {
        StringBuilder sb = new StringBuilder();
        for (String key : carsPosition.keySet()) {
            checkStepForward(key);
            String signs = convertPositionToSigns(carsPosition.get(key));
            sb.append(StringFormatter.raceResultFormat(key, signs));
        }
        return sb.append("\n")
                .toString();
    }

    public String getWinner() {
        int maxValue = Collections.max(carsPosition.values());
        return StringFormatter.winnerFormat(getWinnerToMaxValue(maxValue));
    }

    private void checkStepForward(String key) {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
        if (randomNumber >= LEAST_VALUE_TO_STEP_FORWARD) {
            int changedPosition = carsPosition.get(key) + STEP_FORWARD_SPACE_COUNT;
            carsPosition.put(key, changedPosition);
        }
    }

    private String convertPositionToSigns(int position) {
        return CONVERTING_SIGNS.repeat(position);
    }

    private String getWinnerToMaxValue(int maxValue) {
        return carsPosition.keySet()
                .stream()
                .filter(name -> carsPosition.get(name).equals(maxValue))
                .collect(Collectors.joining(DELIMITER_WHEN_WINNER_IS_PLURAL));
    }
}
