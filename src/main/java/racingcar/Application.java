package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String inputNames = getInput("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String[] carNames = inputNames.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5 || carName.matches(".*\\d.*")) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이고 숫자가 포함되면 안 됩니다.");
            }
        }

        int tryCount = Integer.parseInt(getInput("시도할 회수는 몇 회인가요?"));

        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        int carCount = carNames.length;
        int[][] carPositions = new int[carCount][tryCount];

        simulateRace(carNames, tryCount, carCount, carPositions);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    private static void simulateRace(String[] carNames, int tryCount, int carCount, int[][] carPositions) {
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

        printWinners(carNames, tryCount, carCount, carPositions);
    }

    private static void printWinners(String[] carNames, int tryCount, int carCount, int[][] carPositions) {
        int[] maxPositions = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            for (int j = 0; j < tryCount; j++) {
                maxPositions[i] = Math.max(maxPositions[i], carPositions[i][j]);
            }
        }
        int maxPosition = maxPositions[0];
        for (int i = 1; i < carCount; i++) {
            maxPosition = Math.max(maxPosition, maxPositions[i]);
        }
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carCount; i++) {
            if (maxPositions[i] == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }
        System.out.println("\n최종 우승자 : " + winners);
    }
}


