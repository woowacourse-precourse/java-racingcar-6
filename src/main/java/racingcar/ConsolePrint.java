package racingcar;

public class ConsolePrint {
    private StringBuilder moveTrace = new StringBuilder();
    public void requestCarNameInput() {
        System.out.println(Message.CAR_NAME_REQUEST.getValue());
    }

    public void requestTryCountInput() {
        System.out.println(Message.TRY_COUNT_REQUEST.getValue());
    }
    public void informRacingResult() {
        System.out.println(Message.RESULT_RACING_INFO.getValue());
    }

    public void racingTryResult(Car name, CarStatus status) {
        moveTrace.append(name).append(" : ");
        if (status.equals(CarStatus.MOVE)) {
            moveTrace.append("-");
        }
        System.out.println(moveTrace.toString());
    }

    public void finalWinner() {

    }
}
