package racingcar;

import static console.Printer.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final List<Car> cars = new ArrayList<>();

    private static final int NAME_LIMIT = 5;
    public static void main(String[] args) {
        printCarInputMessage();
        String[] carNames = carsInputByName();
        for (String name : carNames) cars.add(new Car(name));

        printTryInputMessage();
        int tryCount = tryInput();
        makeCarsMove(tryCount);

        printResultMessage();
        List<Car> winners = decideWinners(cars);
        printWinners(winners);
    }

    private static String[] carsInputByName() {

        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.length() > NAME_LIMIT) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        return carNames;
    }

    private static int tryInput() {
        return Integer.parseInt(Console.readLine());
    }

    private static void makeCarsMove(int tryCount) {
        for(int i = 0; i < tryCount ; i++) {
            for (Car car : cars) {
                car.move();
                car.printStatus();
            }
            printNewLine();
        }
    }

    private static List<Car> decideWinners(List<Car> cars) {
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
