package racingcar.utils.validator;


import java.util.ArrayList;

public class GetNameValidator {

    private GetNameValidator() {

    }

    public static void validateStringNames(String carsName) {
        validateBlank(carsName);
        validateCommaPosition(carsName);
        validateNotFormat(carsName);
    }

    private static void validateBlank(String carsName) {
        if (carsName.contains(" ")) {
            throw new IllegalArgumentException("공백");
        }
    }

    private static void validateCommaPosition(String carsName) {
        if (carsName.startsWith(",") || carsName.endsWith(",")) {
            throw new IllegalArgumentException(",의 위치를 확인해주세요");
        }
    }


    private static void validateNotFormat(String carsName) {
        if (!carsName.matches("^[a-zA-Z0-9,가-힣]*$")) {
            throw new IllegalArgumentException("문자, 숫자, 컴마만 입력해주세요");
        }
    }


    public static void validateArrayListNames(ArrayList<String> carsNameList) {
        validateOverDigit(carsNameList);
        validateDupicateName(carsNameList);
        validateCarsNumber(carsNameList);
    }

    private static void validateOverDigit(ArrayList<String> carsNameList) {
        if (carsNameList.stream()
                .filter((carName) -> carName.length() > 5)
                .count() > 0) {
            throw new IllegalArgumentException("5자 이상");
        }
    }

    private static void validateDupicateName(ArrayList<String> carsNameList) {
        if (carsNameList.size() != carsNameList.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException("중복된 이름");
        }
    }

    private static void validateCarsNumber(ArrayList<String> carsNameList) {
        if (carsNameList.stream()
                .count() < 2) {
            throw new IllegalArgumentException("2개 미만");
        }
    }


}
