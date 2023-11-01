package view;

import constants.OutputMessage;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public void requestCarNames(){
        System.out.println(OutputMessage.CAR_NAME_INPUT_PROMPT);
    }

    public void requestAttemptTimes(){
        System.out.println(OutputMessage.ATTEMPT_TIMES_INPUT_PROMPT);
    }

    public void noticeRaceStart(){
        System.out.println(OutputMessage.RESULT_PRINT_START_STATEMENT);
    }

    public void printAttemptResult(String name, String movement){
        System.out.printf("%s : %s\n", name, movement);
    }

    public void printWinner(String winnerName){
        System.out.printf("최종 우승자 : %s\n", winnerName);
    }
}