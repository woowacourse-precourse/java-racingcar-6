package racingcar.util;

public enum ViewMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 " + GameSettingCharacter.SEPARATOR_NAME +
            "(" + GameSettingCharacter.SEPARATOR_CHARACTER + ") 기준으로 구분)"),
    COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final String viewMessage;

    ViewMessage(String viewMessage) {
        this.viewMessage = viewMessage;
    }

    public String get() {
        return viewMessage;
    }
}
