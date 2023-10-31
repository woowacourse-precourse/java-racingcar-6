package view;

import constants.OutputMessage;

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
}