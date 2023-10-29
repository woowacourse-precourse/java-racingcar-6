package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class RaceView {
    public String getCarListInput() {
        return Console.readLine();
    }

    public String getAttemptInput() {
        return Console.readLine();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s\n", winnerNames);
    }

    public void printProgress(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            String name = car.getName();
            String progress = "-".repeat(car.getPosition());
            sb.append(String.format("%s : %s%n", name, progress));
        }
        sb.append('\n');
        System.out.print(sb);
    }
}
