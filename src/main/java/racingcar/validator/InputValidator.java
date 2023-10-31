package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]*");

    private InputValidator() { }

    public static void validateName(String[] carNames) {
        for(String name : carNames){
            if (!NAME_PATTERN.matcher(name).matches()) {
                throw ErrorMessage.INVALID_NAME.getNameException();
            }
        }
    }

    public static void validateNameLength(String[] carNames) {
        for (String name : carNames) {
            if(name.length() > Car.MAX_NAME_LENGTH){
                throw ErrorMessage.INVALID_NAME_LENGTH.getNameException();
            }
        }
    }

    public static void validateDuplicateName(String[] carNames) {
        if (hasDuplicateName(carNames)) {
            throw ErrorMessage.DUPLICATE_NAME.getNameException();
        }
    }

    private static boolean hasDuplicateName(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                return true;
            }
        }
        return false;
    }
}