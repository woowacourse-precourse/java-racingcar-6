package racingcar.model;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private static final String REGEX_FOR_SEPARATE = ",";
    private final List<Car> racingCarList;

    private RacingGame(final String inputNameString) {
        validateInputNameString(inputNameString);
        String[] carNames = splitInputNameString(inputNameString);

        racingCarList = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> racingCarList.add(Car.from(name)));
    }

    public static RacingGame of(final String inputNameString) {
        return new RacingGame(inputNameString);
    }

    public List<Result> play() {
        return racingCarList.stream()
                .map(Car::move)
                .toList();
    }

    public List<String> determineRaceWinners() {
        Collections.sort(racingCarList);
        int winnerMoveCount = racingCarList.get(0).getMovedCount();
        return findWinners(winnerMoveCount);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }

    private List<String> findWinners(int winnerMoveCount) {
        List<String> winnerNameList = new ArrayList<>();
        for(Car car : racingCarList) {
            if(car.getMovedCount() < winnerMoveCount) break;
            winnerNameList.add(car.getName());
        }
        return winnerNameList;
    }

    private void validateInputNameString(String inputNameString) {
        if(isNull(inputNameString)) throw new IllegalArgumentException();
        if(inputNameString.isBlank()) throw new IllegalArgumentException();
    }

    private String[] splitInputNameString(String inputNameString) {
        return inputNameString.split(REGEX_FOR_SEPARATE);
    }
}
