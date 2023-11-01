package racingcar.view;

import java.util.List;
import racingcar.Constant;
import racingcar.domain.Car;

public class OutputView {

    public static void printHead() {
        System.out.println("실행결과");
    }

    private static void showPosition(Car car) {
        for (int i = 0; i < car.getCurrentPosition(); i++) {
            System.out.print("-");
        }
    }

    private static void showCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        showPosition(car);
        System.out.println();
    }

    public static void showScore(List<Car> cars) {
        for (Car car : cars) {
            showCarScore(car);
        }
        System.out.println();
    }

    public static void showWinners(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));
        if (isAloneWin(carNames)) {
            System.out.println();
            return;
        }
        for (int i = 1; i < carNames.size(); i++) {
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
        System.out.println();
    }

    private static boolean isAloneWin(List<String> carNames) {
        return carNames.size() == Constant.ALONE;
    }
}
