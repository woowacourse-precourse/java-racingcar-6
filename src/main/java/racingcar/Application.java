package racingcar;

import controllers.GameController;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import models.Car;
import views.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        ConsoleView view = new ConsoleView(console);

        List<Car> cars = createCars(console);
        int tries = getTries(console);

        GameController gameController = new GameController(cars, view, console);
        gameController.startGame(tries);
    }

    private static List<Car> createCars(Console console) {
        console.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }

    private static int getTries(Console console) {
        console.print("시도할 회수는 몇회인가요?");
        return console.readInt();
    }
}
