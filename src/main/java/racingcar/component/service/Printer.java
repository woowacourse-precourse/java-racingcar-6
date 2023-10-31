package racingcar.component.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import racingcar.component.domain.Car;

public class Printer {
    private Printer() {}

    private static Printer printer;

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void printCurrent(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        Queue<Car> winners = getWinners(cars);

        sb.append("최종 우승자 : ").append(winners.poll().getName());

        while (!winners.isEmpty()) {
            sb.append(", ").append(winners.poll().getName());
        }

        System.out.println(sb);
    }

    private Queue<Car> getWinners(List<Car> cars) {
        int top;
        int i = 0;
        Queue<Car> winners = new LinkedList<>();

        Collections.sort(cars);
        top = cars.get(0).getProgress().length();

        while (cars.get(i).getProgress().length() == top) {
            winners.add(cars.get(i));
            i++;
        }

        return winners;
    }
}
