package racingcar.validation;

public class Validation {

    public static boolean validateApplicantCars(String carNames) {
        if (hasSpace(carNames)) {
            throw new IllegalArgumentException("입력 값에 공백 존재");
        }

        if (!isEnglish(carNames)) {
            throw new IllegalArgumentException("영문 외에 글자 존재");
        }

        return true;
    }

    private static boolean hasSpace(String carNames) {
        return carNames.matches("\"^[\\\\s]*$\"");
    }

    private static boolean isEnglish(String carNames) {
        return carNames.matches("^[a-zA-Z]*$");
    }

    public static boolean validateRaceCount(String raceCount) {
        if (!isNumberType(raceCount)) {
            throw new IllegalArgumentException("정수 아닌 다른 값 잘못 입력");
        }

        if (!isNumberInRange(Integer.parseInt(raceCount))) {
            throw new IllegalArgumentException("random 값 범위 초과, 범위 : 0 ~ 9");
        }

        return true;
    }

    private static boolean isNumberType(String raceCount) {
        return raceCount.matches("^[\\d]*$");
    }

    public static boolean isNumberInRange(int random) {
        if (random < 0 || 9 < random) {
            return false;
        }
        return true;
    }
}
