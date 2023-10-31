package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = carNameInput();
        int retryCount = getRetryCount();
        List<String> results = resultArray(cars); // 결과값 배열 생성

        System.out.println();
        System.out.println("실행 결과");

        playGame(cars, retryCount, results);

        determineWinners(cars, results);
    }

    private static List<String> carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = Arrays.asList(input.split(","));

        for (String car : cars) {
            String carName = car.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        return cars;
    }

    private static int getRetryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    private static List<String> resultArray(List<String> cars) {
        List<String> results = new ArrayList<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            results.add("");
        }
        return results;
    }

    private static void playGame(List<String> cars, int retryCount, List<String> results) {
        for (int i = 0; i < retryCount; i++) {
            updateCarResults(cars, results);
            System.out.println();
        }
    }

    private static void updateCarResults(List<String> cars, List<String> results) {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) results.set(i, results.get(i) + "-");
            System.out.println(cars.get(i) + " : " + results.get(i));
        }
    }

    private static void determineWinners(List<String> cars, List<String> results) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            int distance = results.get(i).length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(cars.get(i));
            } else if (distance == maxDistance) {
                winners.add(cars.get(i));
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
