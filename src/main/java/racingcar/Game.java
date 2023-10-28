package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public static void start() {
        List<Car> cars = readCarNames();
        int gameCount = readGameCount();
        // TODO: game();
    }

    public static List<Car> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        Console.close();

        List<String> names = Arrays.asList(input.split(","));
        Validation.validateCarNames(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int readGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();
        Console.close();

        Validation.validateGameCount(input);
        return Integer.parseInt(input);
    }
}
