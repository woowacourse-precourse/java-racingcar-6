package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        Map<String, Integer> cars = setupCars();
        int rounds = setupRounds();

        for (int round = 0; round < rounds; round++) {
            race(cars);
        }

        int highestScore = findHighestScore(cars);
        findWinner(cars, highestScore);

    }

    public static Map<String, Integer> setupCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return getCarNamesFromInput(input);
    }

    public static Map<String, Integer> getCarNamesFromInput(String input) {
        Map<String, Integer> cars = new LinkedHashMap<>();
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

    public static int setupRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int rounds = Integer.parseInt(input);
        return rounds;
    }

    public static void race(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            cars.put(car, cars.get(car) + moveOrStay());
            printRoundResult(cars, car);
        }
    }

    public static int moveOrStay() {
        int randomNum = Randoms.pickNumberInRange(1, 9);
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }

    public static void printRoundResult(Map<String, Integer> cars, String car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car).append(" : ").append("-".repeat(cars.get(car))).append(" ");
        System.out.println(stringBuilder);
    }

    public static int findHighestScore(Map<String, Integer> cars) {
        return cars.values().stream().max((o1, o2) -> o1 - o2).get();
    }

    public static void findWinner(Map<String, Integer> cars, int highestScore) {
        List<String> winners = cars.keySet().stream()

                .filter(car -> cars.get(car) == highestScore)
                .collect(Collectors.toList());
        printWinners(winners);
    }

    public static void printWinners(List<String> winners) {
        String winnerString = String.join(", ", winners);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ").append(winnerString);
        System.out.println(stringBuilder);
    }

}
