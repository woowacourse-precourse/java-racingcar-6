package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String input = inputCarName();
        Map<String, Integer> racingCars = validateCarName(input);
        int count = inputMovingCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            play(racingCars);
            System.out.println();
        }

        printWinner(racingCars);
    }

    private static void printWinner(Map<String, Integer> racingCars) {
        System.out.println("최종 우승자 : " + parseWinner(racingCars));
    }

    public static String parseWinner(Map<String, Integer> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxValue = Collections.max(racingCars.values());
        for (Map.Entry<String, Integer> entry : racingCars.entrySet()) {
            if (entry.getValue() == maxValue) {
                winners.add(entry.getKey());
            }
        }
        return String.join(", ", winners);
    }

    private static void play(Map<String, Integer> racingCars) {
        for (Map.Entry<String, Integer> entry : racingCars.entrySet()) {
            int number = Randoms.pickNumberInRange(0, 9);
            int forward = moveCar(entry.getValue(), number);
            racingCars.replace(entry.getKey(), forward);

            output(entry.getKey(), forward);
        }
    }

    private static void output(String key, int forward) {
        System.out.println(key + " : " + "-".repeat(Math.max(0, forward)));
    }

    public static int moveCar(int value, int number) {
        if (number >= 4) {
            return value + 1;
        }
        return value;
    }

    private static int inputMovingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return parseInt(input);
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Map<String, Integer> validateCarName(String input) {
        Map<String, Integer> racingCars = new LinkedHashMap<>();
        String[] cars = input.split(",");
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            racingCars.put(car, 0);
        }
        return racingCars;
    }
}
