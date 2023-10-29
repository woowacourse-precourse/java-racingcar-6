package racingcar.validator;

import static racingcar.constant.Constant.CAR_NAME_MAX_SIZE;
import static racingcar.constant.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.EMPTY_CAR_NAME;
import static racingcar.constant.ExceptionMessage.OVER_SIZE_CAR_NAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.Input;

public class InputValidator {

    private List<String> validateCarNames;
    private Input input = new Input();

    public InputValidator(String validateCarNames) {
        convertValidateList(validateCarNames);
        removeSpaceInCarName();
        hasDuplicatedName();
        validateCarNameLength();
        validateEmptyCarName();
    }

    private void convertValidateList(String carNames) {
        this.validateCarNames = Arrays.stream(carNames.split(",")).toList();
    }

    protected List<String> removeSpaceInCarName() {
        this.validateCarNames = validateCarNames.stream().map(carName -> carName.replaceAll("\\s", ""))
                .collect(Collectors.toList());
        return validateCarNames;
    }

    private void hasDuplicatedName() {
        HashSet<String> duplicateValidSet = new HashSet<>(validateCarNames);
        if (duplicateValidSet.size()!=this.validateCarNames.size()) {
            input.close();
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    private void validateCarNameLength() {
        validateCarNames.stream()
                .filter(carName -> carName.length() > CAR_NAME_MAX_SIZE)
                .findAny()
                .ifPresent(carName -> {
                    input.close();
                    throw new IllegalArgumentException(OVER_SIZE_CAR_NAME.getMessage());
                });
    }

    private void validateEmptyCarName() {
        validateCarNames.stream()
                .filter(carName -> carName.length()==0)
                .findAny()
                .ifPresent(carName -> {
                            input.close();
                            throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
                        }
                );
    }
}
