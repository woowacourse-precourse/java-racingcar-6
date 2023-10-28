package racingcar.validator;

import java.util.List;

import static racingcar.global.GameConstant.*;

public class CarNameInputValidator {

    public List<String> validateAndGetCarNames(String userInput) {
        validateNotEmpty(userInput);
        validateSeparator(userInput);
        List<String> carNames= splitCarNames(userInput);
        validateLength(carNames);
        validateDuplicate(carNames);
        return carNames;
    }

    private void validateNotEmpty(String userInput){
        if(userInput.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void validateSeparator(String userInput){
        if(!userInput.contains(CAR_NAME_SEPARATOR.getValue())){
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(List<String> carNames){
        if(hasValidLength(carNames)){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<String> carNames){
        if (hasDuplicates(carNames)){
            throw new IllegalArgumentException();
        };
    }

    private static boolean hasValidLength(List<String> carNames){
        return carNames.stream()
                .noneMatch(name -> name.length()>5);
    }

    private static boolean hasDuplicates(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private List<String> splitCarNames(String userInput){
        userInput = userInput.trim();
        return List.of(userInput.split(CAR_NAME_SEPARATOR.getValue()));
    }
}
