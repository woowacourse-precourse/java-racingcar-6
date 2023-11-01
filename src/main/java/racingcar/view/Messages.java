package racingcar.view;

public enum Messages {

    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    GAME_TURN_INPUT("시도할 회수는 몇회인가요?\n"),
    GAME_RESULT("실행 결과\n"),
    WINNER("최종 우승자 : "),
    ILLEGAL_NAME("이름 형식이 잘못되었습니다\n"),
    ILLEGAL_NUMBER("숫자 형식이 아닙니다\n"),
    ILLEGAL_NUMBER_RANGE("0이상의 수를 입력해주세요\n");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(this.message);
    }

    public String getMessage() {
        return message;
    }
}
