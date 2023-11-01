package racingcar.controller;

import static racingcar.utility.Constants.MAX_LENGTH;
import static racingcar.utility.Constants.ONLYINT;

import racingcar.model.Car;
import racingcar.model.CarStorage;

public class InputException {
    private InputException() {}
    public static void checkAllCarName(String newCarName) {
        checkNameLength(newCarName);
        checkOnlyInt(newCarName);
        checkExistCar(newCarName);
        checkNameNonEmpty(newCarName);
    }
    public static void checkAllTryCount(String tryCount) {
        checkTryCountNonInteger(tryCount);
        checkTryCountOverZero(tryCount);
    }

    private static void checkNameNonEmpty(String newCarName) { // 이름이 공백인 경우 예외처리
        if (newCarName.equals("") == true) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkNameLength(String newCarName) { // 이름 길이 5자 초과 예외처리
        if (newCarName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkOnlyInt(String newCarName) { // 숫자로만 이루어진 이름 예외처리
        if (newCarName.matches(ONLYINT)) {
            throw new IllegalArgumentException();
        }
    }
    private static void checkExistCar(String newCarName) { // 같은 이름의 자동차 사용 예외처리
        String carName;
        for (Car car : CarStorage.cars()) {
            carName = car.name();
            if (newCarName.equals(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }
    private static void checkTryCountOverZero(String tryCount) { // 실행횟수가 공백이면 예외처리
        try {
            Integer intTryCount = Integer.parseInt(tryCount); // 정수로 변환을 시도
            if (intTryCount <= 0) { // 0 이하 정수인 경우 예외 처리
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) { // 정수 변환 실패 시 예외 처리
            throw new IllegalArgumentException();
        }
    }
    private static void checkTryCountNonInteger(String tryCount) { // 실행횟수가 정수가 아니면 예외처리
        try {
            Integer intTryCount = Integer.parseInt(tryCount); // 정수로 변환을 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
