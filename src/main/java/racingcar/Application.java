package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    static int tryTimes;
    static List<String> carNames = new ArrayList<>();
    static Map<String, Integer> carScore = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        printStartMessage();
        nameCar();
        askTryTimes();
        runRacingGame();
        printWinner();
    }

    private static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void nameCar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] names = input.split(",");

        for (String name : names) {
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            carNames.add(name);
            carScore.put(name, 0);
        }
    }

    private static void askTryTimes() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            tryTimes = Integer.parseInt(br.readLine());
            if (tryTimes <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }

    private static void runRacingGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryTimes; i++) {
            for (String name : carNames) {
                if (getGoStop()) {
                    carScore.put(name, carScore.get(name) + 1);
                }
                printCarProgress(name);
            }
            System.out.println();
        }
    }

    private static void printCarProgress(String name) {
        int score = carScore.get(name);
        System.out.print(name + " : ");
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static boolean getGoStop() {
        return getRandomNumber() >= 4;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private static void printWinner() {
        int maxScore = Collections.max(carScore.values());
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carScore.entrySet()) {
            if (entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
