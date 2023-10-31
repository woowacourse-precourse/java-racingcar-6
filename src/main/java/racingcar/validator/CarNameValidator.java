package racingcar.validator;

import racingcar.util.ExtractElementUtil;

import java.util.List;

import static racingcar.constant.MessageConstant.*;
import static racingcar.constant.SystemConstant.*;

public class CarNameValidator {

    private static final ExtractElementUtil extractElementUtil = new ExtractElementUtil();

    public static void checkCarNamesInput(String input) {
        checkEmpty(input);
        checkLastIndex(input);

        List<String> nameList = extractElementUtil.extractCarNames(input);
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
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_DUPLICATE);
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
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_MAX);
        }
        if (name.length() < LENGTH_OF_CAR_NAME_MIN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_MIN);
        }
    }

    private static void checkBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_BLANK);
        }
    }

    private static void throwCarNameInputException() { // 자동차 이름 입력이 올바르지 않을 때
        throw new IllegalArgumentException(ERROR_MESSAGE_NAME_INPUT);
    }

}
