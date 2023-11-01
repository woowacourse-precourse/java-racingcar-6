package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void outputMessage() {
        System.out.println("실행 결과");
    }

    public static void outputResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : ");
            outputPosition(car);
        }
    }

    private static void outputPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.println("-");
        }
    }

    public static void outputWinners(List<String> carNames) {
        System.out.println("최종 우승자 : ");
        System.out.println(carNames.get(0));
        if (carNames.size() == 1) {
            return;
        }
        for (int i = 1; i < carNames.size(); i++) {
            System.out.println(", ");
            System.out.println(carNames.get(i));
        }
    }
}
