package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String inputNames = getInput("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String[] carNames = inputNames.split(",");
        int tryCount = Integer.parseInt(getInput("시도할 회수는 몇 회인가요?"));
        int carCount = carNames.length;
        int[][] carPositions = new int[carCount][tryCount];

        printResult(carNames, tryCount, carCount, carPositions);
        printWinners(carNames, tryCount, carCount, carPositions);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    private static void printResult(String[] carNames, int tryCount, int carCount, int[][] carPositions) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                carPositions[j][i] = randomValue;
            }
        }
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                System.out.println(carNames[j] + " : " + "-".repeat(Math.max(0, carPositions[j][i])));
            }
            System.out.println();
        }
    }

    private static void printWinners(String[] carNames, int tryCount, int carCount, int[][] carPositions) {
        int maxPosition = 0;
        for (int i = 0; i < carCount; i++) {
            for (int j = 0; j < tryCount; j++) {
                maxPosition = Math.max(maxPosition, carPositions[i][j]);
            }
        }
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carCount; i++) {
            if (carPositions[i][tryCount - 1] == maxPosition) {
                if (!winners.isEmpty()) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }
        System.out.println("\n최종 우승자: " + winners);
    }
}
