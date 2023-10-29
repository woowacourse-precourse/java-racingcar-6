package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printRace(car);
        }
        System.out.println();
    }

    public static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (Car car : winners) {
            sb.append(car.getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }
}
