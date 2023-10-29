package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.StringFormatter;

public final class CarsPosition {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int LEAST_VALUE_TO_STEP_FORWARD = 4;
    private static final int STEP_FORWARD_COUNT = 1;
    private static final String POSITION_SIGNS = "-";
    private static final String DELIMITER_WHEN_WINNER_IS_PLURAL = ", ";

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
            carsPosition.put(key, carsPosition.get(key) + STEP_FORWARD_COUNT);
        }
    }

    private String convertPositionToSigns(int position) {
        return POSITION_SIGNS.repeat(position);
    }

    private String getWinnerToMaxValue(int maxValue) {
        return carsPosition.keySet()
                .stream()
                .filter(name -> carsPosition.get(name).equals(maxValue))
                .collect(Collectors.joining(DELIMITER_WHEN_WINNER_IS_PLURAL));
    }
}
