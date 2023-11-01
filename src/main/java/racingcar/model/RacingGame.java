package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private List<RacingCar> racingCars;
    private int raceCount;

    public void createCarsAfterValidation(final String carNamesInputLine) {
        this.validateContainSpace(carNamesInputLine);
        this.validateDuplicateCarNames(carNamesInputLine);

        final List<String> carNames = this.convertStringToListCarNames(carNamesInputLine);
        this.racingCars = carNames.stream().map(RacingCar::new).toList();
    }

    public void setRaceCountAfterValidation(final String raceCountInputLine) {
        this.validateDigitRaceCount(raceCountInputLine);
        this.validateEmptyRaceCount(raceCountInputLine);

        final int raceCount = this.convertStringToIntRaceCount(raceCountInputLine);

        this.raceCount = raceCount;
    }

    public void round() {
        for (RacingCar car : this.racingCars) {
            final int movableNumber = this.generateMovableNumber();

            car.move(movableNumber);
        }
    }

    public List<List<Score>> race() {
        List<List<Score>> result = new ArrayList<>();

        for (int i = 0; i < this.raceCount; i++) {
            this.round();
            result.add(this.racingCars.stream().map(RacingCar::getScore).toList());
        }

        return result;
    }

    public List<String> getWinners() {
        final List<Integer> carsMoveCounts = this.racingCars.stream()
                .map(RacingCar::getMoveCount).toList();

        final int maxMove = Collections.max(carsMoveCounts);

        final List<String> winners = this.racingCars.stream()
                .filter(car -> car.getMoveCount() == maxMove)
                .map(RacingCar::getRacingCarName).toList();

        return winners;
    }

    public int generateMovableNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void validateContainSpace(final String carNameInputLine) {
        if (carNameInputLine.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_ERROR.getDelimiterError());
        }
    }

    public void validateDuplicateCarNames(final String carNameInputLine) {
        final String[] carNames = carNameInputLine.split("," , -1);
        Set<String> dulplicateSet = Arrays.stream(carNames).collect(Collectors.toSet());

        if (dulplicateSet.size() != carNames.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME_ERROR.getDuplicatedCarNamesError());
        }
    }

    public List<String> convertStringToListCarNames(final String carNameInputLine) {
        final String[] carNames = carNameInputLine.split("," , -1);
        final List<String> convertedValues = Arrays.stream(carNames).toList();

        return convertedValues;
    }

    public void validateDigitRaceCount(final String raceCountInput) {
        if (raceCountInput.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException(ErrorMessage.DIGIT_RACE_COUNT_ERROR.getDigitRaceCountError());
        }
    }

    public void validateEmptyRaceCount(final String raceCountInput) {
        if (raceCountInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_RACE_COUNT_ERROR.getEmptyRaceCountError());
        }
    }

    public int convertStringToIntRaceCount(final String raceCountInput) {
        if (raceCountInput.equals("0")) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_RACE_COUNT_ERROR.getZeroRaceCountError());
        }

        final int raceCount = Integer.parseInt(raceCountInput);

        return raceCount;
    }
}
