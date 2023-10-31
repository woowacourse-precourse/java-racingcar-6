package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Map<String, Integer> cars = getCarNamesFromInput(input);

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        int rounds = Integer.parseInt(input);

        for (int round = 0; round < rounds; round++) {
            race(cars);
        }

    }

    public static Map<String, Integer> getCarNamesFromInput(String input) {
        Map<String, Integer> cars = new HashMap<>();
        for (String car : input.split(",")) {
            checkLengthOfInput(car);
            cars.put(car, 0);
        }
        return cars;
    }

    public static void checkLengthOfInput(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void race(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            cars.put(car, cars.get(car) + moveOrStay());
            printRoundResult(cars, car);
        }
    }

    private static void printRoundResult(Map<String, Integer> cars, String car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car).append(" : ");
        for(int i = 0; i < cars.get(car); i++){
            stringBuilder.append("-");
        }
        stringBuilder.append(" ");
        System.out.println(stringBuilder);
    }

    public static int moveOrStay() {
        int randomNum = Randoms.pickNumberInRange(1, 9);
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }
}
