package racingcar.Message;

public enum RoundExceptionPrompt {
    STRINGPROMPT("문자열을 입력하셨습니다.\n시도 횟수는 정수만 입력 가능합니다.\n입력한 값 : %s"),
    REALNUMBERPROMPT("실수를 입력하셨습니다. \n시도 횟수는 정수만 입력 가능합니다.\n입력한 값 : %s"),
    RANGEPROMPT("시도 횟수는 1 이상이어야 합니다.\n입력한 값 : %s");

    private String message;

    RoundExceptionPrompt(String message) {
        this.message = message;
    }

    public String getMessage(String round) {
        return String.format(this.message, round);
    }
}
