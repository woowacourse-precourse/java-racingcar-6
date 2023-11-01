package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public static final String WINNER_RESULT = "최종 우승자 : ";
    public static final String DELIMITER_WINNER = ", ";
    public static void printStartMessage(){
        System.out.println("실행 결과");
    }

    public static void printTryResult(ArrayList<String> tryResults){
        tryResults.forEach(System.out::println);
        System.out.println();
    }
    public static void printWinner(ArrayList<String> winners){
        System.out.println(WINNER_RESULT+String.join(DELIMITER_WINNER, winners));
    }

}
