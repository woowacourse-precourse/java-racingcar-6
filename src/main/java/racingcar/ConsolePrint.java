package racingcar;

public class ConsolePrint {
    public void requestCarNameInput() {
        System.out.println(Message.CAR_NAME_REQUEST.getMessage());
    }

    public void requestTryCountInput() {
        System.out.println(Message.TRY_COUNT_REQUEST.getMessage());
    }
    public void informRacingResult() {
        System.out.println(Message.RESULT_RACING_INFO.getMessage());
    }

    public void racingTryResult(String name, int status) {

    }

    public void finalWinner() {

    }
}
