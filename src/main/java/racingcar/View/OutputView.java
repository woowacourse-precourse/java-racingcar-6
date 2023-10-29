package racingcar.View;

import java.util.List;
import racingcar.Domain.Car;

public class OutputView {
    public static void showHeaderPrompt() {
        System.out.println("실행 결과");
    }

    public static void showRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            showCarLocation(car);
            System.out.println();
        }
        System.out.println();
    }

    public static void showFinalWinners(List<String> carNames) {
        System.out.print("최종 우승자 : " + carNames.get(0));
        if (!checkSingleWinner(carNames)) {
            for (int i = 1; i < carNames.size(); i++) {
                System.out.print(", " + carNames.get(i));
            }
        }
        System.out.println();
    }

    public static void showCarNameAndTryCountException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private static void showRoundCarLocation(Car car) {
        System.out.print(car.getName() + " : ");
        showCarLocation(car);
        System.out.println();
    }

    private static void showCarLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }

    private static boolean checkSingleWinner(List<String> carNames) {
        return carNames.size() == 1;
    }
}