package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = splitCarNames(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        int numAttempts = Integer.parseInt(Console.readLine());

        List<String> results = CarNameColon(carNames);

    }

    private static boolean shouldCarMove() {
        int move = Randoms.pickNumberInRange(0, 9);
        return move >= 4;
    }

    private static List<String> splitCarNames(String input) {
        String[] carNamesArray = input.split(",");
        validateCarNames(carNamesArray);
        return List.of(carNamesArray);
    }

    private static void validateCarNames(String[] carNamesArray) {
        for (String name : carNamesArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<String> CarNameColon(List<String> carNames) {
        List<String> results = new ArrayList<>();
        for (String carName : carNames) {
            results.add(carName + " : ");
        }
        return results;
    }

    private static void printResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
}
