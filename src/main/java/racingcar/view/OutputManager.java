package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class OutputManager {
    public void printCarStatus(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(String.format("%s : %s", car.getCarName(), "-".repeat(car.getAdvanceCount())));
        });
        System.out.println();
    }

    public void printMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        IntStream.range(0, winners.size()).forEach(idx -> {
            if (idx == 0) {
                System.out.print(winners.get(idx).getCarName());
            } else {
                System.out.print(", " + winners.get(idx).getCarName());
            }
        });
    }
}
