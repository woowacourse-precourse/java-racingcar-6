package racingcar.Message;

public enum GamePrompt {
    INPUTCARNAMEMESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUTROUNDMESSAGE("시도할 회수는 몇회인가요?\n"),
    OUTPUTRESULTMESSAGE("실행 결과\n"),
    OUTPUTCARPOSITIONMESSAGE("%s : %s\n"),
    OUTPUTFINALWINNERMESSAGE("최종 우승자 : %s");

    private String message;

    GamePrompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
