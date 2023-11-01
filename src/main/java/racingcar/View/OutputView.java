package racingcar.View;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    public static final String WINNER_GUIDE_MESSAGE = "최종 우승자 : ";
    public static final String GAME_RESULT_MESSAGE = "실행 결과";

    public void printRounds(int roundTrialNum) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i; i < roundTrialNum; i++) {
            printCarsResult();
            System.out.println("/n");
        }
    }

    public void printCarsResult() {
    }

    public StringBuilder printCarResult(String name, int position) {
        StringBuilder sb = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
            return sb;
        }
    }

    public void printWinners(ArrayList<String> winners) {
        System.out.println(WINNER_GUIDE_MESSAGE + winners.stream()
                .collect(Collectors.joining((", "))));
    }
}
