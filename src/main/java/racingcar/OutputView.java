package racingcar;

public class OutputView {

    public static void outputRacingStatus(Cars cars) {
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
