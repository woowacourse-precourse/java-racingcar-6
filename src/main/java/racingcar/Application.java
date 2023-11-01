package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        int count = getCount();

        int[] carProgress = new int[carNames.length];
        System.out.println("");
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            updateCarProgress(carNames, carProgress);
            printCarProgress(carNames, carProgress);
            System.out.println("");
        }

        String winnerName = checkWinnerName(carNames, carProgress);
        System.out.println("최종 우승자: " + winnerName);
    }


    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("5자 이내로 입력해야 합니다.");
            }
        }

        return carNames;
    }

    private static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        return count;
    }

    private static void updateCarProgress(String[] carNames, int[] carProgress) {
        for (int j = 0; j < carNames.length; j++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                carProgress[j]++;
            }
        }
    }

    private static void printCarProgress(String[] carNames, int[] carProgress) {
        for (int t = 0; t < carNames.length; t++) {
            System.out.println(carNames[t] + " : " + "-".repeat(carProgress[t]));
        }
    }

    private static String checkWinnerName(String[] carNames, int[] carProgress) {
        int winner = 0;
        StringBuilder winnerName = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (carProgress[i] > winner) {
                winner = carProgress[i];
                winnerName.setLength(0);
                winnerName.append(carNames[i]);
            } else if (carProgress[i] == winner) {
                winnerName.append(carNames[i]);
            }
        }
        return winnerName.toString();
    }
}
