package racingcar.constant;

public enum ServiceMessage {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT("시도할 회수는 몇회인가요?\n"),
    OUTPUT("실행 결과\n"),
    WINNER("최종 우승자 :");
    public String serviceMessage;

    ServiceMessage(String serviceMessage) {
        this.serviceMessage = serviceMessage;
    }
}
