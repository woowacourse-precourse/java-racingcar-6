package ui;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        StringJoiner winnerJoiner = new StringJoiner(", ");

        for (Car car : winners) {
            winnerJoiner.add(car.getName());
        }

        System.out.println(winnerJoiner);
    }
}
