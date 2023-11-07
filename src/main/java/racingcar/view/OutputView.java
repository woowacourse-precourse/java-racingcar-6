package racingcar.view;

import racingcar.domain.Car;

import static racingcar.constants.OutputViewConstants.*;

public class OutputView {

    public static void printCarStatus(Car car) {
        String carStatus = generateCarStatus(car);
        System.out.println(carStatus);
    }

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinningCar(String winningCarNames) {
        System.out.printf(FINAL_WINNER_RESULT_FORMAT,winningCarNames);
    }

    private static String generateCarStatus(Car car) {
        StringBuilder carStatusBuilder = new StringBuilder();
        carStatusBuilder.append(String.format(CAR_NAME_FORMAT, car.getName()));

        for (int i = 0; i < car.getPosition(); i++) {
            carStatusBuilder.append(POSITION_SYMBOL);
        }

        return carStatusBuilder.toString();
    }
}

