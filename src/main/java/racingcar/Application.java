package racingcar;

import static console.Input.carNamesInput;
import static console.Input.tryInput;
import static console.Printer.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final List<Car> cars = new ArrayList<>();
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
