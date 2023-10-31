package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    public static void printStart() {
        System.out.println(Message.START_MESSAGE.getMessage());
    }

    public static void printAsk() {
        System.out.println(Message.ASK_ATTEMPT.getMessage());
    }

    public static void printResult() {
        System.out.println();
        System.out.println(Message.RESULT.getMessage());
    }

    public static void printStatus(ArrayList<String> resultList) {
        StringBuilder sb = new StringBuilder();

        for (String result : resultList) {
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static void printWinner(ArrayList<String> winnerList) {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.WINNER.getMessage());

        for (int i = 0; i < winnerList.size(); i++) {
            if(i==winnerList.size()-1) sb.append(" ").append(winnerList.get(i));
            else sb.append(" ").append(winnerList.get(i)).append(",");
        }

        System.out.println(sb);
    }
}
