package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            long distance = car.getDistance();
            StringBuilder hyphen = new StringBuilder();

            for (long i = 0; i < distance; i++) {
                hyphen.append("-");
            }

            System.out.println(name + " : " + hyphen);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            System.out.print(winner.getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}