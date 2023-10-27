package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public static final String CAR_NAME_FORMAT = "%s : ";
    public static final String POSITION_SYMBOL = "-";
    public static final String FINAL_WINNER_RESULT_FORMAT = "최종 우승자 : %s";

    public static void printCarPosition(Car car) {
        String resultString = "";

        resultString += String.format(CAR_NAME_FORMAT, car.getName());

        for (int i = 0; i < car.getPosition(); i++) {
            resultString += POSITION_SYMBOL;
        }

        System.out.println(resultString);
    }

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinningCar(String winningCarNames) {
        System.out.printf(FINAL_WINNER_RESULT_FORMAT,winningCarNames);
    }
}

