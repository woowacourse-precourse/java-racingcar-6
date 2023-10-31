package racingcar.view;

import java.util.List;
import racingcar.model.RacingModel;

public class OutputView {

    private final String START_RACING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";
    private final String RESULT = "\n실행 결과";
    private final String DISTANCE = "-";
    private final String WINNER = "최종 우승자 : ";

    public void printStarting() {
        System.out.println(START_RACING);
    }

    public void printTimes() {
        System.out.println(NUMBER_OF_TIMES);
    }

    public void printResult() {
        System.out.println(RESULT);
    }

    public void printRacing(List<String> players, int[] distance_list) {

        for (int num = 0; num < players.size(); num++) {
            System.out.println(players.get(num) + " : " + DISTANCE.repeat(distance_list[num]));
        }
        System.out.println();

    }

    public void printWinner(String winner) {

        System.out.print(WINNER + winner);

    }

}
