package racingcar;

import java.util.ArrayList;

public class OutputGame {
    private enum Message {
        EXECUTION_RESULT("실행 결과"),
        RESULT_FORMAT("%s : %s%n"),
        DASH("-"),
        WINNER("최종 우승자 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

    private final int START = 0;

    public void printGame() {
        System.out.println(Message.EXECUTION_RESULT.message);

    }

    public void printRacing(ArrayList<String> carName, ArrayList<Integer> position) {
        for (int order = START; order < carName.size(); order++) {
            System.out.printf(Message.RESULT_FORMAT.message, carName.get(order),
                    Message.DASH.message.
                            repeat(position.get(order)));
        }
        System.out.println();
    }

    public void printWinner(ArrayList<String> winner) {
        System.out.print(Message.WINNER.message);
        System.out.println(String.join(", ", winner));
    }


}
