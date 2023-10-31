package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<String> askCarNames() {
        List<String> carNames = new ArrayList<String>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input[] = Console.readLine().replaceAll("\\p{Z}", "").split(",");

        for (String x : input) {
            if(x.length() <=5) {
                carNames.add(x);
            }
            else throw new IllegalArgumentException();
        }
        return carNames;
    }

    public static int askMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        try {
            int d = Integer.parseInt(input);
        } catch(NumberFormatException e) { throw new IllegalArgumentException(); }
        int moveCount = Integer.parseInt(input);
        System.out.print("\n");
        return moveCount;
    }
}
