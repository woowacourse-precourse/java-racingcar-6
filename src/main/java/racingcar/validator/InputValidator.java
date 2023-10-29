package racingcar.validator;

import static racingcar.constant.Constant.CAR_NAME_MAX_SIZE;
import static racingcar.constant.Constant.MAX_VALUE;
import static racingcar.constant.Constant.ZERO;
import static racingcar.constant.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.EMPTY_CAR_NAME;
import static racingcar.constant.ExceptionMessage.MAX_VALUE_MESSAGE;
import static racingcar.constant.ExceptionMessage.NOT_NUMBER_MESSAGE;
import static racingcar.constant.ExceptionMessage.OVER_SIZE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.ZERO_NUMBER_MESSAGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.Input;

public class InputValidator {

    private List<String> validateCarNames;
    private Integer playTime;
    private Input input;

    public InputValidator() {
    }

    public InputValidator(String validateCarNames) {
        input = new Input();
        convertValidateList(validateCarNames);
        removeSpaceInCarName();
    }

    public List<String> convertList() {
        return this.validateCarNames;
    }

    public void validateCarNames() {
        hasDuplicatedName();
        validateCarNameLength();
        validateEmptyCarName();
    }

    protected void convertValidateList(String carNames) {
        this.validateCarNames = Arrays.stream(carNames.split(",")).toList();
    }

    protected List<String> removeSpaceInCarName() {
        this.validateCarNames = validateCarNames.stream().map(carName -> carName.replaceAll("\\s", ""))
                .collect(Collectors.toList());
        return validateCarNames;
    }

    protected void hasDuplicatedName() {
        HashSet<String> duplicateValidSet = new HashSet<>(validateCarNames);
        if (duplicateValidSet.size()!=this.validateCarNames.size()) {
            input.close();
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    protected void validateCarNameLength() {
        validateCarNames.stream()
                .filter(carName -> carName.length() > CAR_NAME_MAX_SIZE)
                .findAny()
                .ifPresent(carName -> {
                    input.close();
                    throw new IllegalArgumentException(OVER_SIZE_CAR_NAME.getMessage());
                });
    }

    protected void validateEmptyCarName() {
        validateCarNames.stream()
                .filter(carName -> carName.length()==0)
                .findAny()
                .ifPresent(carName -> {
                            input.close();
                            throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
                        }
                );
    }

    public void validateTime(String playTimeInput) {
        Integer playTime = validateNumber(playTimeInput);
        validateZero(playTime);
        validateMaxValue(playTime);
        this.playTime = playTime;
    }

    public Integer getPlayTime() {
        return this.playTime;
    }

    protected Integer validateNumber(String playTime) {
        if (!playTime.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE.getMessage());
        }
        return Integer.parseInt(playTime);
    }

    protected void validateZero(Integer playTime) {
        if (playTime.equals(ZERO)) {
            throw new IllegalArgumentException(ZERO_NUMBER_MESSAGE.getMessage());
        }
    }

    protected void validateMaxValue(Integer playTime) {
        if (playTime > MAX_VALUE) {
            throw new IllegalArgumentException(MAX_VALUE_MESSAGE.getMessage());
        }
    }

}
