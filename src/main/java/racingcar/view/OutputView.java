package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String name = car.getName();
            long distance = car.getDistance();
            StringBuilder hyphen = new StringBuilder();

            for (long j = 0; j < distance; j++) {
                hyphen.append("-");
            }

            System.out.println(name + " : " + hyphen);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            String winner = winners.get(i);
            System.out.print(winner);
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}