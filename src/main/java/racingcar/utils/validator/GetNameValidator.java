package racingcar.utils.validator;


import java.util.ArrayList;

public class GetNameValidator {

    public static final String BLANK_ERROR_MESSAGE = "공백 없이 입력해주세요";
    public static final String COMMA_POSITION_ERROR_MESSAGE = "콤마의 위치를 확인해주세요";
    public static final String NOT_FORMAT_ERROR_MESSAGE = "문자, 숫자, 컴마만 입력해주세요";
    public static final String DIGIT_ERROR_MESSAGE = "이름은 1자 이상 5자 이하로 입력해주세요";
    public static final String DUPLICATE_ERROR_MESSAGE = "중복된 이름이 있습니다";
    public static final String CARS_NUMBER_ERROR_MESSAGE = "2대 이상이 필요합니다";

    private GetNameValidator() {

    }

    public static void validateStringNames(String carsName) {
        validateBlank(carsName);
        validateCommaPosition(carsName);
        validateNotFormat(carsName);
    }

    private static void validateBlank(String carsName) {
        if (carsName.contains(" ")) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateCommaPosition(String carsName) {
        if (carsName.startsWith(",") || carsName.endsWith(",")) {
            throw new IllegalArgumentException(COMMA_POSITION_ERROR_MESSAGE);
        }
    }


    private static void validateNotFormat(String carsName) {
        if (!carsName.matches("^[a-zA-Z0-9,가-힣]*$")) {
            throw new IllegalArgumentException(NOT_FORMAT_ERROR_MESSAGE);
        }
    }


    public static void validateArrayListNames(ArrayList<String> carsNameList) {
        validateOverDigit(carsNameList);
        validateUnderDigit(carsNameList);
        validateDuplicateName(carsNameList);
        validateCarsNumber(carsNameList);
    }

    private static void validateOverDigit(ArrayList<String> carsNameList) {
        if (carsNameList.stream()
                .filter((carName) -> carName.length() > 5)
                .count() > 0) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    private static void validateUnderDigit(ArrayList<String> carsNameList) {
        if (carsNameList.stream()
                .filter((carName) -> carName.length() == 0)
                .count() > 0) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }


    private static void validateDuplicateName(ArrayList<String> carsNameList) {
        if (carsNameList.size() != carsNameList.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateCarsNumber(ArrayList<String> carsNameList) {
        if (carsNameList.stream()
                .count() < 2) {
            throw new IllegalArgumentException(CARS_NUMBER_ERROR_MESSAGE);
        }
    }

}
