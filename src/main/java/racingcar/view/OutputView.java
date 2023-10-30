package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String HYPHEN = "-";

    public static void outputRacingStatus(Cars cars) {
        outputCarRacingStatus(cars);
        System.out.println();
    }

    public static void outputWinnerRacingCarNames(Cars cars) {
        List<String> winnerCarNameList = cars.getWinnerCarNameList();
        String winnerRacingCar = joinWinnerRacingCar(winnerCarNameList);
        printWinnerRacingCar(winnerRacingCar);
    }

    private static void outputCarRacingStatus(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(makeRacingStatus(car));
        }
    }

    private static String makeRacingStatus(Car car) {
        return car.getName()
                + COLON
                + convertForwardToHyphen(car.getForward());
    }

    private static String convertForwardToHyphen(Integer forward) {
        return HYPHEN.repeat(forward);
    }

    private static String joinWinnerRacingCar(List<String> winnerCarNameList) {
        return String.join(COMMA, winnerCarNameList);
    }

    private static void printWinnerRacingCar(String winnerCarNames) {
        System.out.println(FINAL_WINNER + winnerCarNames);
    }
}
