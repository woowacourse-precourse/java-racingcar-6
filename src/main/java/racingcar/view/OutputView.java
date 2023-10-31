package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.constant.MessageConstant.USER_OUTPUT_MESSAGE;

public class OutputView {

    public static void showHead() {
        System.out.println(USER_OUTPUT_MESSAGE);
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
