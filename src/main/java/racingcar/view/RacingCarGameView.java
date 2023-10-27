package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingResult;

import java.util.Map;

public class RacingCarGameView {

    private static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 회수는 몇회인가요?";

    public RacingCarGameView() {

    }

    public String inputCarNames() {
        System.out.println(START);
        String inputNames = Console.readLine();

        return inputNames;
    }

    public int inputTryCount() {
        System.out.println(TRY_COUNT);
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    public void printResult(RacingResult racingResult) {

        Map<String, Integer> result = racingResult.getResult();

        for (String s : result.keySet()) {
            System.out.print(s + " : ");
            int count = result.get(s);
            while(count > 0) {
                System.out.print("-");
                count--;
            }
            System.out.println();
        }

    }

}
