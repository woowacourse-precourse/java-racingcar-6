package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    public static void printHead() {
        System.out.println("실행 결과");
    }
    //시행 횟수 마다 결과 호출
    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printCarScore(car);
            System.out.println();
        }
        System.out.println();
    }
    //최종 우승자 호출
    public static void printWinners(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));

        for (int i = 1; i < carNames.size(); i++) {
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
    }

    private static void printCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
