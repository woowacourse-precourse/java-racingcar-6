package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] cars = carNameInput();// 자동차 이름 입력 받기
        int retryCount = getRetryCount();// 시도 횟수 입력 받기
        String[] results = resultArray(cars); // 결과값 배열 생성

        System.out.println();
        System.out.println("실행 결과");

        playGame(cars, retryCount, results); // 게임 시작

        determineWinners(cars, results); // 우승자 출력
    }

    private static String[] carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] cars = input.split(",");

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

    private static String[] resultArray(String[] cars) {
        String[] result = new String[cars.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = "";
        }

        return result;
    }

    private static void playGame(String[] cars, int retryCount, String[] results) {
        for (int i = 0; i < retryCount; i++) {
            updateCarResults(cars, results); // 이동 결과 출력
            System.out.println();
        }
    }

    private static void updateCarResults(String[] cars, String[] results) {
        for (int i = 0; i < cars.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) results[i] += "-";
            System.out.println(cars[i] + " : " + results[i]);
        }
    }

    private static void determineWinners(String[] cars, String[] results) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            int distance = results[i].length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(cars[i]);
            } else if (distance == maxDistance) {
                winners.add(cars[i]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
