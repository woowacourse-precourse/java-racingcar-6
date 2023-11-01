package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;




public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] carNames = inputNames.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        for (String car: carNames) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5 이하이어야 합니다.");
            }
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        int carCount = carNames.length;
        int[] positions = new int[carCount];

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    positions[j]++;
                }
            }
            printRoundResults(carNames, positions);
        }

        printWinners(carNames, positions);
    }

    private static void printRoundResults(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < positions[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printWinners(String[] carNames, int[] positions) {
        int maxPosition = 0;
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

        System.out.println("최종 우승자 : " + winners.toString());
    }
}
