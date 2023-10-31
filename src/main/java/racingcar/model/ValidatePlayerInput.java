package racingcar.model;

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
        this.validateAlphaCarName();
        this.validateCarNameLength();
        this.validateDuplicateCarNames();

        final List<String> validateResult = this.convertStringToListCarNames();

        return validateResult;
    }
    
    public int validateRaceCount(final String raceCountInput) {
        this.validateEmptyRaceCount(raceCountInput);
        this.validateEmptyRaceCount(raceCountInput);

        final int validateResult = Integer.parseInt(raceCountInput);

        return validateResult;
    }

    public void validateContainSpace(String playerInput) {
        if (playerInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름 구분은 ','로 하셔야합니다");
        }
    }

    public void validateNotContainCarName() {
        if (Arrays.stream(splitsCarNamesInput).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("레이싱 자동차 이름이 없습니다");
        }
    }

    public void validateAlphaCarName() {
        if (Arrays.stream(this.splitsCarNamesInput)
                .anyMatch(carName -> !Pattern.matches("^[a-zA-Z]*$", carName))) {
            throw new IllegalArgumentException("레이싱 자동차 이름은 영어만 허용됩니다");
        }
    }

    public void validateCarNameLength() {
        if (Arrays.stream(this.splitsCarNamesInput).anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름 길이는 5이하 입니다");
        }
    }

    public void validateDuplicateCarNames() {
        Set<String> dulplicateSet = Arrays.stream(this.splitsCarNamesInput).collect(Collectors.toSet());

        if (dulplicateSet.size() != this.splitsCarNamesInput.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다");
        }
    }

    public void validateDigitRaceCount(String raceCountInput) {
        if (raceCountInput.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException("숫자만 입력해주시길 바랍니다");
        }
    }

    public void validateEmptyRaceCount(String raceCountInput) {
        if (raceCountInput.isEmpty()) {
            throw new IllegalArgumentException("레이스 횟수를 입력하시길 바랍니다");
        }
    }

    public List<String> convertStringToListCarNames() {
        final List<String> convertedValues = Arrays.stream(this.splitsCarNamesInput).toList();

        return convertedValues;
    }
}
