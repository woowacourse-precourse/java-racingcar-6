package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private List<String> validateCarNames;

    public InputValidator(String validateCarNames) {
        convertValidateList(validateCarNames);
    }

    private void convertValidateList(String carNames){
        this.validateCarNames = Arrays.stream(carNames.split(",")).toList();
    }

}
