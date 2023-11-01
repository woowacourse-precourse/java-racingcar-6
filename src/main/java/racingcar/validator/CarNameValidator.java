package racingcar.validator;

import racingcar.util.ReturnElementUtil;

import java.util.List;

import static racingcar.constant.SystemConstant.*;
import static racingcar.constant.ValidatorConstant.*;

public class CarNameValidator {

    private static final ReturnElementUtil returnElementUtil = new ReturnElementUtil();

    public static void checkCarNamesInput(String input) {
        checkEmpty(input);
        checkLastIndex(input);

        List<String> nameList = returnElementUtil.extractCarNames(input);
        checkAllDuplicate(nameList);
        checkEachLengthAndBlank(nameList);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throwCarNameInputException();
        }
    }

    private static void checkLastIndex(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwCarNameInputException();
        }
    }

    private static void checkAllDuplicate(List<String> nameList) {
        for (int i = 0; i < nameList.size(); i++) {
            for (int j = i + 1; j < nameList.size(); j++) {
                checkDuplicate(nameList.get(i), nameList.get(j));
            }
        }
    }

    private static void checkDuplicate(String nameOne, String nameTwo) {
        if (nameOne.equals(nameTwo)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_DUPLICATE.getMessage());
        }
    }

    private static void checkEachLengthAndBlank(List<String> nameList) {
        for (String name : nameList) {
            checkLength(name);
            checkBlank(name);
        }
    }

    private static void checkLength(String name) {
        if (LENGTH_OF_CAR_NAME_MAX < name.length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_MAX.getMessage());
        }
        if (name.length() < LENGTH_OF_CAR_NAME_MIN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_MIN.getMessage());
        }
    }

    private static void checkBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_BLANK.getMessage());
        }
    }

    private static void throwCarNameInputException() {
        throw new IllegalArgumentException(ERROR_MESSAGE_NAME_INPUT.getMessage());
    }

}
