package racingcar;

public class Validator {
    public static void validateInput(String[] cars, int trys) {
        for (String car: cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5 이하이어야 합니다.");
            }
        }

        if (trys <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
