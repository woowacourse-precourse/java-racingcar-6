package racingcar.service;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingGameException;
import racingcar.model.Car;
import racingcar.model.CarStatus;
import racingcar.util.RandomUtil;
import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingGameService {
    private final List<Car> racingCarList;

    private static final String DELIMITER = ",";
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private RacingGameService(final String inputName) {
        validateInputName(inputName);
        String[] carNames = StringUtil.splitByDelimiter(inputName, DELIMITER);
        validateDuplicateName(carNames);

        racingCarList = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> racingCarList.add(Car.make(StringUtil.removeLeadingAndTrailingWhitespace(name))));
    }

    public static RacingGameService make(final String inputName) {
        return new RacingGameService(inputName);
    }

    public List<CarStatus> play() {
        return racingCarList.stream()
                .map(car -> car.moveOrStop(RandomUtil.generateRandomValue(MIN_VALUE, MAX_VALUE)))
                .toList();
    }

    public List<String> getRaceWinners() {
        return findWinners(getWinnerMoveCnt());
    }

    private int getWinnerMoveCnt() {
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

    private void validateInputName(String inputName) {
        if(inputName == null)
            throw new RacingGameException(ErrorMessage.NULL_INPUT);
        if(inputName.isBlank()) 
            throw new RacingGameException(ErrorMessage.EMPTY_INPUT);
    }
    
    private void validateDuplicateName(String[] carNames) {
        long uniqueCarNameCount = Arrays.stream(carNames)
                .distinct()
                .count();

        if (uniqueCarNameCount != carNames.length) {
            throw new RacingGameException(ErrorMessage.DUPLICATED_NAME);
        }
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}
