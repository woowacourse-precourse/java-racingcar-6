package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class GameOutputView {
    private static final String PROCESS_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printRacingProcess(List<Car> cars) {
        System.out.println();
        System.out.println(PROCESS_START_MESSAGE);
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            printHyphen(car.getNowNum());
            System.out.println();
        });
    }

    private static void printHyphen(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }

    public static void printCarsName(List<Car> cars) {
        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getName());
            System.out.print(",");
        }
        System.out.println(cars.get(cars.size() - 1).getName());
    }
}
