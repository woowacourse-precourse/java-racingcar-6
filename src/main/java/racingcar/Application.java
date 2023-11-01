package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private static final String ERROR_MESSAGE = "ERROR: 자동차 이름은 5자 이하로 입력해주세요.";

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");

        int tryCount = Integer.parseInt(Console.readLine().trim());

        int[] positions = playGame(carNames, tryCount);

        printFinalResult(carNames, positions);
    }
    private static int[] playGame(String[] carNames, int tryCount) {
        int[] positions = new int[carNames.length];

        for (int i = 0; i < tryCount; i++) {
            updatePositions(carNames, positions);

            for (int l = 0; l < carNames.length; l++) {
                System.out.println(carNames[l] + " : " + "-".repeat(positions[l]));
            }
            System.out.println();
        }

        return positions;
    }

    private static void updatePositions(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            if (isMove()) {
                positions[i]++;
            }
        }
    }

    private static boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MINIMUM_MOVE_NUMBER;
    }

    private static void printFinalResult(String[] carNames, int[] positions) {
        int maxPosition = getMaxPosition(positions);
        List<String> winners = getWinners(carNames, positions, maxPosition);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static int getMaxPosition(int[] positions) {
        int maxPosition = 0;
        for (int position : positions) {
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private static List<String> getWinners(String[] carNames, int[] positions, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                winners.add(carNames[i]);
            }
        }
        return winners;
    }
}
