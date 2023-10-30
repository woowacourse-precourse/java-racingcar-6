package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Communicator {
    public static List<String> instructInputCars() {
        printStart();
        String carsInput = Console.readLine();
        List<String> cars = Arrays.stream(carsInput.split(","))
                .map(String::strip)
                .toList();
        Validator.validateCars(cars);
        return cars;
    }

    public static int instructInputGameTimes() {
        printInputGameTimes();
        return Integer.parseInt(Console.readLine());
    }

    private static void printInputGameTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
