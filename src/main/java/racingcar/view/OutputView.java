package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private OutputView() {
    }

    public static String progressView(List<Car> cars) {
        String carProgress = "";

        for (Car car : cars) {
            carProgress += progressView(car) + "\n";
        }

        return carProgress;
    }

    public static String progressView(Car car) {
        String carProgress = car.getName() + " : ";

        for (int distance = 0; distance < car.getForwardDistance(); distance++) {
            carProgress += '-';
        }

        return carProgress;
    }

    public static String finalWinnerView(List<Car> cars) {
        String winners = cars.get(0).getName();

        for (int duplicationWinnerIndex = 1; duplicationWinnerIndex < cars.size(); duplicationWinnerIndex++) {
            winners = winners + ", " + cars.get(duplicationWinnerIndex).getName();
        }

        return "최종 우승자 : " + winners;
    }
}
