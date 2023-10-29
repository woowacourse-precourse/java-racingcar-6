package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public static final String CAR_NAME_FORMAT = "%s : ";
    public static final String POSITION_SYMBOL = "-";
    public static final String FINAL_WINNER_RESULT_FORMAT = "최종 우승자 : %s";
    public static final String RESULT_HEADER = "\n실행 결과";

    public static void printCarStatus(Car car) {
        String carStatus = generateCarStatus(car);
        System.out.println(carStatus);
    }

    private static String generateCarStatus(Car car) {
        StringBuilder carStatusBuilder = new StringBuilder();
        carStatusBuilder.append(String.format(CAR_NAME_FORMAT, car.getName()));

        for (int i = 0; i < car.getPosition(); i++) {
            carStatusBuilder.append(POSITION_SYMBOL);
        }
        return carStatusBuilder.toString();
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
}

