package racingcar;

import static console.Input.carNamesInput;
import static console.Input.tryInput;
import static console.Printer.*;
import static racingcar.Car.createCar;
import static racingcar.Car.decideWinners;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final List<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        printCarInputMessage();
        String[] carNames = carNamesInput();
        for (String name : carNames) cars.add((createCar(name)));

        printTryInputMessage();
        int tryCount = tryInput();

        makeCarsMove(tryCount);

        printResultMessage();
        List<Car> winners = decideWinners(cars);
        printWinners(winners);
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
}
