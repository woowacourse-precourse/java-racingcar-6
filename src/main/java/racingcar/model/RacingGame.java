package racingcar.model;

import static java.util.Objects.isNull;
import static racingcar.common.exception.ErrorMessage.DUPLICATED_NAME;
import static racingcar.common.exception.ErrorMessage.EMPTY_INPUT_STRING;
import static racingcar.common.exception.ErrorMessage.NULL_INPUT_STRING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.common.exception.RacingGameException;
import racingcar.util.StringUtil;

public class RacingGame {

    private static final String DELIMITER = ",";
    private final List<Car> racingCarList;

    private RacingGame(final String inputNameString) {
        validateInputNameString(inputNameString);
        String[] carNames = StringUtil.splitByDelimiter(inputNameString, DELIMITER);
        validateDuplicateName(carNames);

        racingCarList = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> racingCarList.add(Car.from(StringUtil.removeLeadingAndTrailingWhitespace(name))));
    }

    public static RacingGame from(final String inputNameString) {
        return new RacingGame(inputNameString);
    }

    public List<Result> play() {
        return racingCarList.stream()
                .map(Car::move)
                .toList();
    }

    public List<String> determineRaceWinners() {
        int winnerMoveCount = getWinnerMoveCount();
        return findWinners(winnerMoveCount);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }

    private int getWinnerMoveCount() {
        Collections.sort(racingCarList);
        return racingCarList.get(0).getMovedCount();
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
        if(isNull(inputNameString)) throw new RacingGameException(NULL_INPUT_STRING);
        if(inputNameString.isBlank()) throw new RacingGameException(EMPTY_INPUT_STRING);
    }

    private void validateDuplicateName(String[] carNames) {
        long uniqueCarNameCount = Arrays.stream(carNames)
                .distinct()
                .count();

        if (uniqueCarNameCount != carNames.length) {
            throw new RacingGameException(DUPLICATED_NAME);
        }
    }
}
