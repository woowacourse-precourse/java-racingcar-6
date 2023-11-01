package racingcar.validator;

import java.util.List;

public class CarValidator {

    public static void validateCarName(String carName) {

        if (!isValidCarName(carName)) {
            throw new IllegalArgumentException("자동차 이름은 앞,뒤 공백 없는 1~5자 사이입니다.");
        }
    }

    public static void validateDuplicatedCarName(List<String> carNames) {
        long uniqueCount = getUniqueCount(carNames);

        if (isDuplicated(carNames, uniqueCount)) {
            throw new IllegalArgumentException("자동차 이름이 중복되지 않아야 합니다.");
        }
    }

    public static void validateNumberOfCar(List<String> carNames) {

        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차가 레이스에 참여해야 합니다.");
        }
    }

    private static boolean isValidCarName(String carName) {
        return (carName.length() <= 5) && (carName.length() > 0);
    }

    private static long getUniqueCount(List<String> carNames) {
        return carNames.stream().distinct().count();
    }

    private static boolean isDuplicated(List<String> carNames, long uniqueCount) {
        return uniqueCount < carNames.size();
    }
}
