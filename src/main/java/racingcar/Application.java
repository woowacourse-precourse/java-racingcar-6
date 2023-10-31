package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = getCarNames(sc.nextLine());
        int[] carPositions = new int[carNames.length];
        int numAttempts = getNumAttempts(sc.nextLine());
        Race(carNames, carPositions, numAttempts);
        System.out.println(printWinner(carNames, carPositions));

    }

    public static String[] getCarNames(String names) {
        String[] nameSplit = names.split(",");
        for (int i = 0; i < nameSplit.length; i++) {
            if (nameSplit[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하만 가능합니다.");
            }
        }
        return nameSplit;
    }

    public static int getNumAttempts(String numAttempt) {
        System.out.println("시도할 회수는 몇회인가요?");
        if (!numAttempt.matches("[0-9]+")) {
            throw new IllegalStateException("숫자로 입력해주세요");
        }
        int numAttempts = Integer.parseInt(numAttempt);
        return numAttempts;
    }

    public static void Race(String[] carNames, int[] carPositions, int numAttempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < numAttempts; i++) {
            for (int j = 0; j < carNames.length; j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= 4) {
                    carPositions[j]++;
                }
                System.out.print(carNames[j] + " : ");
                System.out.println("-".repeat(carPositions[j]));
            }
            System.out.println();
        }
    }

    public static String printWinner(String[] carNames, int[] carPositions) {
        int maxScore = 0;
        for (int position : carPositions) {
            maxScore = Math.max(maxScore, position);
        }
        if (maxScore > 0) {
            LinkedList<String> winner = new LinkedList<>();
            for (int i = 0; i < carNames.length; i++) {
                if (carPositions[i] == maxScore) {
                    winner.add(carNames[i]);
                }
            }
            return "최종 우승자 : " + String.join(", ", winner);
        } else {
            return "최종 우승자는 없습니다.";
        }

    }

}
