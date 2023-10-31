package racingcar.view.messages;

public enum Messages {
    INPUT_CAR_NAMES_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT_GUIDE("시도할 횟수는 몇회인가요?"),
    GAME_RESULT_GUIDE("실행 결과"),
    WINNERS_GUIDE("최종 우승자 : ");

    private final String message;

    Messages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
