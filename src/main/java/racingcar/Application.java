package racingcar;

import static console.Printer.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        printCarInputMessage();
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) cars.add(new Car(name));

        printTryInputMessage();
        int tryCount = Integer.parseInt(Console.readLine());

        printResultMessage();
        for(int i = 0; i < tryCount ; i++) {
            for (Car car : cars) {
                car.move();
                car.printStatus();
            }
            printNewLine();
        }
        List<Car> winners = decideWinners(cars);
        printWinners(winners);
    }

    public static List<Car> decideWinners(List<Car> cars) {
        return cars.stream().filter(car -> car.getDistance() == getMaxDistance(cars)).collect(Collectors.toList());
    }

    private static int getMaxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }
}
