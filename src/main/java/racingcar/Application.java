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
        String[] carNames = carNamesInput();
        for (String name : carNames) addCarToList(createCar(name));

        printTryInputMessage();
        int tryCount = tryInput();

        makeCarsMove(tryCount);

        printResultMessage();
        List<Car> winners = decideWinners(cars);
        printWinners(winners);
    }

    private static void addCarToList(Car car) {
        cars.add(car);
    }

    private static Car createCar(String name) {
        return new Car(name);
    }

    private static String[] carNamesInput() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.length() > NAME_LIMIT) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        return carNames;
    }

    private static int tryInput() {
        try {
            int tryCount = Integer.parseInt(Console.readLine());
            if (tryCount <= 0 || tryCount >= 9) throw new IllegalArgumentException("입력값은 0에서 9 사이여야 합니다.");
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 자료형입니다.");
        }
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
