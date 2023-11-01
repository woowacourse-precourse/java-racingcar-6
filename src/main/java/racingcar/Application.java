package racingcar;

import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        playGame(carNames, tryCount);
    }

    private static void playGame(String[] carNames, int tryCount) {
        int carCount = carNames.length;
        int[] positions = new int[carCount];

        for (int round = 0; round < tryCount; round++) {
            for (int carIndex = 0; carIndex < carCount; carIndex++) {
                int move = generateRandomNumber();
                if (move >= 4) {
                    positions[carIndex]++;
                }
            }
            printRoundResult(carNames, positions);
        }

        determineWinners(carNames, positions);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private static void printRoundResult(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < positions[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void determineWinners(String[] carNames, int[] positions) {
        int maxPosition = -1;
        for (int position : positions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }
        System.out.println("최종 우승자: " + winners.toString());
    }
}
