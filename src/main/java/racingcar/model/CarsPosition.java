package racingcar.model;

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
        return sb.toString();
    }

    public String getWinner() {
        int maxValue = Collections.max(carsPosition.values());
        return StringFormatter.winnerFormat(getWinnerToMaxValue(maxValue));
    }

    private void checkStepForward(String key) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carsPosition.put(key, carsPosition.get(key) + 1);
        }
    }

    private String convertPositionToSigns(int position) {
        return "-".repeat(position);
    }

    private String getWinnerToMaxValue(int maxValue) {
        return carsPosition.keySet()
                .stream()
                .filter(name -> carsPosition.get(name).equals(maxValue))
                .collect(Collectors.joining(", "));
    }
}
