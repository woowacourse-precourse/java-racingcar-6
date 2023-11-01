package racingcar.validation;

public class Validation {

    public static boolean validateApplicantCars(String carNames) {
        if (hasSpace(carNames)) {
            throw new IllegalArgumentException("입력 값에 공백 존재");
        }

        if (!isEnglish(carNames)) {
            throw new IllegalArgumentException("영문 외에 글자 존재");
        }

        if (!isLengthNames(carNames)) {
            throw new IllegalArgumentException("5글자 이하만 가능");
        }

        return true;
    }

    private static boolean hasSpace(String carNames) {
        return carNames.matches("\"^[\\\\s]*$\"");
    }

    private static boolean isEnglish(String carNames) {
        return carNames.matches("^[a-zA-Z,]*$");
    }

    private static boolean isLengthNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            int length = carName.length();
            if (length < 1 || 5 < length) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateRaceCount(String raceCount) {
        if (!isNumberType(raceCount)) {
            throw new IllegalArgumentException("정수 아닌 다른 값 잘못 입력");
        }

        if (!isPositiveNumber(Integer.parseInt(raceCount))) {
            throw new IllegalArgumentException("음수 입력 불가");
        }

        return true;
    }

    private static boolean isNumberType(String raceCount) {
        return raceCount.matches("^[\\d]*$");
    }

    public static boolean isPositiveNumber(int random) {
        if (random < 0) {
            return false;
        }
        return true;
    }
}
