package racingcar.input;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public static void validateRaceCount(String stringRaceCount) {
        validateOnlyNumber(stringRaceCount);
        validatePositiveNumber(stringRaceCount);
    }

    private static void validatePositiveNumber(String stringRaceCount){
        if (isPositiveNumber(stringRaceCount)) {
            throw new IllegalArgumentException("입력하실 숫자는 0이상의 수가 아닙니다.");
        }
    }

    private static boolean isPositiveNumber(String stringRaceCount) {
        int raceCount = Integer.parseInt(stringRaceCount);
        return raceCount < 0;
    }

    private static void validateOnlyNumber(String stringRaceCount){
        if (isOnlyNumber(stringRaceCount)) {
            throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
        }
    }

    private static boolean isOnlyNumber(String stringRaceCount) {
        return !stringRaceCount.matches("[0-9]+");
    }

    public static void validateCarList(List<Car> cars) {
        if (isDuplicateCarNames(cars)) {
            throw new IllegalArgumentException("입력하신 차량은 중복되었습니다.");
        }
    }

    private static boolean isDuplicateCarNames(List<Car> cars) {
        List<String> carNameList = cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        return carNameList.size() != carNameList.stream().distinct().count();
    }

    public static void validateCarname(String carName) {
        validateUnderFiveLength(carName);
        validateWhiteSpace(carName);
    }

    private static void validateUnderFiveLength(String carName) {
        if (isOverSixLength(carName)) {
            throw new IllegalArgumentException("입력하신 차량 이름이 6자를 넘었습니다.");
        }
    }

    private static void validateWhiteSpace(String carName) {
        if (isWhiteSpace(carName)) {
            throw new IllegalArgumentException("입력하신 차량은 공백입니다.");
        }
    }

    private static boolean isOverSixLength(String carName) {
        return carName.length() >= 6;
    }

    private static boolean isWhiteSpace(String carName) {
        return carName.isBlank();
    }
}
