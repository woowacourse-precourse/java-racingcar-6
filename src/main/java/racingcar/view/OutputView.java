package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void showHead() {
        System.out.println("실행 결과");
    }

    public static void showScores(List<Car> cars) {
        for (Car car : cars) {
            showCarScore(car);
        }
        System.out.println();
    }

    private static void showCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        showPosition(car);
        System.out.println();
    }

    private static void showPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void showWinners(List<String> carNames) {
        if (isSoloWin(carNames)) {
            System.out.print("최종 우승자 : " + carNames.get(0));
            return;
        }
        String result = String.join(", ", carNames);
        System.out.print(result);
    }

    private static boolean isSoloWin(List<String> carNames) {
        return carNames.size() == 1;
    }

}
