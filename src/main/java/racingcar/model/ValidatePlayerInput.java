package racingcar.model;

import racingcar.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatePlayerInput {
    private String[] splitsCarNamesInput;

    public void convertStringToArray(final String carNamesInput) {
        this.splitsCarNamesInput = carNamesInput.split(",", -1);
    }

    public List<String> validateCarNames(final String carNamesInput) {
        this.convertStringToArray(carNamesInput);
        this.validateContainSpace(carNamesInput);
        this.validateNotContainCarName();
        this.validateCarNameLength();
        this.validateAlphaCarName();
        this.validateDuplicateCarNames();

        final List<String> validateResult = this.convertStringToListCarNames();

        return validateResult;
    }
    
    public int validateRaceCount(final String raceCountInput) {
        this.validateDigitRaceCount(raceCountInput);
        this.validateEmptyRaceCount(raceCountInput);

        final int validateResult = this.convertStringToIntRaceCount(raceCountInput);

        return validateResult;
    }

    public void validateContainSpace(final String playerInput) {
        if (playerInput.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_ERROR.getDelimiterError());
        }
    }

    public void validateNotContainCarName() {
        if (Arrays.stream(splitsCarNamesInput).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.NO_NAME_ERROR.getNoCarsNameError());
        }
    }

    public void validateAlphaCarName() {
        if (Arrays.stream(this.splitsCarNamesInput)
                .anyMatch(carName -> !Pattern.matches("^[a-zA-Z]*$", carName))) {
            throw new IllegalArgumentException(ErrorMessage.ALPHA_NAME_ERROR.getAlphaCarNameError());
        }
    }

    public void validateCarNameLength() {
        if (Arrays.stream(this.splitsCarNamesInput).anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getCarNameLengthError());
        }
    }

    public void validateDuplicateCarNames() {
        Set<String> dulplicateSet = Arrays.stream(this.splitsCarNamesInput).collect(Collectors.toSet());

        if (dulplicateSet.size() != this.splitsCarNamesInput.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME_ERROR.getDuplicatedCarNamesError());
        }
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


    public List<String> convertStringToListCarNames() {
        final List<String> convertedValues = Arrays.stream(this.splitsCarNamesInput).toList();

        return convertedValues;
    }

    public int convertStringToIntRaceCount(String raceCountInput) {
        if (raceCountInput.equals("0")) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_RACE_COUNT_ERROR.getZeroRaceCountError());
        }

        final int raceCount = Integer.parseInt(raceCountInput);

        return raceCount;
    }
}
