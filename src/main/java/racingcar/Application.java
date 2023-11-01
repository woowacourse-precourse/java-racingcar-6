package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        String[] carNames = readCarNames();
        validateCarName(carNames);
        Car[] cars = initializeCars(carNames);
    }

    private static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private static void validateCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static Car[] initializeCars(String[] carNames) {
        int carNumber = carNames.length;
        Car[] cars = new Car[carNumber];
        for (int i = 0; i < carNumber; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
}
