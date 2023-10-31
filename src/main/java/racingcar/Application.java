package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Map<String, Integer> cars = new HashMap<>();
        List<String> carNames;
        carNames = getCarNames();

        setCarInfo(carNames, cars);

        int attempt = getAttempt();
        printRaceResult(attempt, carNames, cars);
        printWinner(cars, carNames);
    }

    private static List<String> getCarNames() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] temp = Console.readLine().split(",");
        carNames = new ArrayList<>(Arrays.asList(temp));
        return carNames;
    }

    private static void setCarInfo(List<String> carNames, Map<String, Integer> cars) {
        for(String str : carNames) {
            if(str.length() >= 6) throw new IllegalArgumentException();
            cars.put(str, 0);
        }
    }

    private static int getAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void printRaceResult(int attempt, List<String> carNames, Map<String, Integer> cars) {
        System.out.println("\n실행 결과");

        for(int i = 0; i < attempt; i++) {
            race(carNames, cars);
        }
    }

    private static void race(List<String> carNames, Map<String, Integer> cars) {
        for(String str : carNames) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                cars.put(str, cars.get(str) + 1);
            }

            System.out.println(str + " : " + "-".repeat(cars.get(str)));
        }

        System.out.println();
    }

    private static void printWinner(Map<String, Integer> cars, List<String> carNames) {
        System.out.print("최종 우승자 : ");
        Integer maxVal = Collections.max(cars.values());
        carNames.removeIf(str -> !(Objects.equals(cars.get(str), maxVal)));
        System.out.println(String.join(",", carNames));
    }
}