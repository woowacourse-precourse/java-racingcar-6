package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> inputCarName = new ArrayList<>();
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() <= 5) {
                inputCarName.add(name);
            } else {
                throw new IllegalArgumentException("5글자 이하만 입력하시오");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = inputTryNumber();
        System.out.println("\n실행 결과");

        int[] scores = new int[inputCarName.size()];
        for (int j = 0; j < tryNumber; j++) {
            for (int i = 0; i < inputCarName.size(); i++) {
                int go = Randoms.pickNumberInRange(0, 9);
                if (go >= 4) {
                    scores[i]++;
                }
            }

            for (int i = 0; i < inputCarName.size(); i++) {
                System.out.print(inputCarName.get(i) + " : ");
                for (int k = 0; k < scores[i]; k++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
        }

        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        System.out.print("최종 우승자 : ");
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                winner.add(inputCarName.get(i));

            }
        }
        String winnerNames = String.join(", ", winner);
        System.out.println(winnerNames);
    }

    private static int inputTryNumber() {
        try {
            int tryNumberInt = Integer.parseInt(Console.readLine());
            if (tryNumberInt <= 0) {
                throw new IllegalArgumentException("양수를 입력하시오");
            }
            return tryNumberInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하시오");
        }
    }
}
