package racingcar;

public class Validator {
    public static void validateCar(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5 || car.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 1~5자여야 합니다.");
            }
        }
    }

    public static void validateCount(String count) {
        try {
            int parsedCount = Integer.parseInt(count);
            if (parsedCount <= 0) {
                throw new IllegalArgumentException("반복 횟수는 자연수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("반복 횟수는 자연수여야 합니다.");
        }
    }
}
