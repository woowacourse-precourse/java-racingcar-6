package racingcar;

public enum Message {
    //자주 사용하는 출력들을 모아놓은 클래스
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    END("최종 우승자 : "),
    COUNT("시도할 회수는 몇회인가요?"),
    ROUNDSTART("실행결과");


    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }


}
