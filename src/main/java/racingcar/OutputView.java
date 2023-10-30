package racingcar;

import java.util.List;

public class OutputView {

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
        return car.getName() + " : "
                + convertForwardToHyphen(car.getForward());
    }

    private static String convertForwardToHyphen(Integer forward) {
        return "-".repeat(forward);
    }

    private static String joinWinnerRacingCar(List<String> winnerCarNameList) {
        return String.join(", ", winnerCarNameList);
    }

    private static void printWinnerRacingCar(String winnerCarNames) {
        System.out.println("최종 우승자 : " + winnerCarNames);
    }
}
