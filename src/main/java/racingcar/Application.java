package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<String> carNames = new ArrayList<>();
    private static List<String> winners = new ArrayList<>();
    private static int carMovingCount;
    private static List<Integer> carMovings = new ArrayList<>();

    private static void displayStartText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void displayCarMovingCountText() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void inputCarNames() {
        String carName = Console.readLine();
        carNames = Arrays.asList(carName.split(","));
    }

    private static void isNameLengthOverFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputCarMovingCount() {
        carMovingCount = Integer.parseInt(Console.readLine());
    }

    private static int randomPickingNumberZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static int decideGoAndStop() {
        int randomNumber = randomPickingNumberZeroToNine();
        if (randomNumber >= 4) {
            return 1;
        }
        return 0;
    }

    private static void countCarMovings() {
        for (int i = 0; i < carMovings.size(); i++) {
            int count = carMovings.get(i);
            carMovings.set(i, count + decideGoAndStop());
        }
    }

    private static void displayTurnResult() {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            displayGoingCount(i);
        }
    }

    private static void displayGoingCount(int index) {
        int GoingCount = carMovings.get(index);
        for (int i = 0; i < GoingCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void decideWinners() {
        int max = 0;

        for (int i = 0; i < carMovings.size(); i++) {
            if (carMovings.get(i) > max) {
                max = carMovings.get(i);
            }
        }

        for (int i = 0; i < carMovings.size(); i++) {
            if (carMovings.get(i) == max) {
                winners.add(carNames.get(i));
            }
        }
    }

    private static void displayWinners() {
        System.out.print(winners.get(0));
        if (winners.size() > 1) {
            System.out.print(", ");
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(winners.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        displayStartText();
        inputCarNames();

        displayCarMovingCountText();
        inputCarMovingCount();

        for (int i = 0; i < carNames.size(); i++) {
            isNameLengthOverFive(carNames.get(i));
        }

        for (int i = 0; i < carNames.size(); i++) {
            carMovings.add(0);
        }

        for (int i = 0; i < carMovingCount; i++) {
            countCarMovings();
            displayTurnResult();
            System.out.println();
        }
        decideWinners();
        displayWinners();
    }
}
