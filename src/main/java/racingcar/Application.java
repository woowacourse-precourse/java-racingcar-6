package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

class Cars {
    public static String[] carNames;
    public static int[] carDistance;
    public static int carNumber;

    public static void readyCars(String[] inputCarNames) {
        carNumber = inputCarNames.length;
        carNames = new String[carNumber];
        carDistance = new int[carNumber];

        for (String carName: inputCarNames) {
            if (carName.length() > 5) throw new IllegalArgumentException();
        }

        System.arraycopy(inputCarNames, 0, carNames, 0, carNumber);
    }
}

class Round {

    private static int nowRound = 0;
    public static int finalRound;

    public Round(int inputNum) {
        finalRound = inputNum;
    }

    public static boolean isContinue() {
        nowRound++;
        return nowRound <= finalRound;
    }
}

class Race {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVING_FORWARD = 4;

    public static List<String> winnerCarNames = new ArrayList<>();

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    private static int moveCar(int randomNum) {
        if (randomNum >= MOVING_FORWARD) {
            return 1;
        }
        return 0;
    }

    public static void goRace() {
        for (int idx = 0; idx < Cars.carNumber; idx++) {
            Cars.carDistance[idx] += moveCar(getRandomNumber());
        }
    }

    public static void showResult() {
        for (int idx = 0; idx < Cars.carNumber; idx++) {
            System.out.printf("%s : %s%n", Cars.carNames[idx], "-".repeat(Cars.carDistance[idx]));
        }
    }

    public static String[] findWinner() {
        int maxDistance = 0;
        for (int idx = 0; idx < Cars.carNumber; idx++) {
            if (Cars.carDistance[idx] > maxDistance) {
                maxDistance = Cars.carDistance[idx];
            }
        }
        System.out.println(maxDistance);
        System.out.println(Arrays.toString(Cars.carDistance));
        for (int idx = 0; idx < Cars.carNumber; idx++) {
            if (Cars.carDistance[idx] == maxDistance) {
                winnerCarNames.add(Cars.carNames[idx]);
            }
        }
        return winnerCarNames.toArray(new String[0]);
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputCarNames = Console.readLine().split(",");
        try {
            Cars.readyCars(inputCarNames);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        Round.finalRound = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        while (Round.isContinue()) {
            Race.goRace();
            Race.showResult();
            System.out.println();
        }

        String[] winnerCarNames = Race.findWinner();

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winnerCarNames));
    }
}
