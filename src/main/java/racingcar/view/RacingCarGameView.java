package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingResult;
import racingcar.model.Winners;

import java.util.List;
import java.util.Map;

public class RacingCarGameView {

    private static final String RESULT = "실행 결과";
    private static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = " : ";
    private static final String FORWARD = "-";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COMMA = ", ";

    public RacingCarGameView() {}

    public String inputCarNames() {
        System.out.println(START);
        String inputNames = Console.readLine();

        return inputNames;
    }

    public int inputTryCount() {
        int count;

        System.out.println(TRY_COUNT);

        try {
            count = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println();
        System.out.println(RESULT);

        return count;
    }

    public void printResult(RacingResult racingResult) {
        Map<String, Integer> result = racingResult.getResult();

        for (String s : result.keySet()) {
            System.out.print(s + DELIMITER);
            int count = result.get(s);

            while(count > 0) {
                System.out.print(FORWARD);
                count--;
            }

            System.out.println();
        }

        System.out.println();
    }

    public void printFinalResult(Winners winners) {
        List<String> temp = winners.getWinners();

        System.out.print(FINAL_WINNER);
        System.out.print(String.join(COMMA, temp));
        System.out.println();
    }
}
