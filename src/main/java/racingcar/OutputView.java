package racingcar;

import java.util.List;

public class OutputView {

    public static void outputRacingStatus(Cars cars) {
        outputCarRacingStatus(cars);
        System.out.println();
    }

    public static void outputWinnerRacingCarNames(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> winnerCarNameList = cars.getWinnerCarNameList();

        stringBuilder.append("최종 우승자 : ");
        for (String winnerCarName : winnerCarNameList) {
            stringBuilder.append(winnerCarName + ", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);

        System.out.println(stringBuilder);
    }

    private static void outputCarRacingStatus(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(makeRacingStatus(car));
        }
    }

    private static String makeRacingStatus(Car car) {
        return car.getName() + " : "
                + forwardToHyphen(car.getForward());
    }

    private static String forwardToHyphen(Integer forward) {
        return "-".repeat(forward);
    }
}
