package racingcar.view;

import racingcar.model.dto.GameStatus;

public enum Messages {

    CAR_NAME_INPUT_ANNOUNCEMENT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    GAME_TURN_INPUT_ANNOUNCEMENT("시도할 회수는 몇회인가요?\n"),
    GAME_RESULT_ANNOUNCEMENT("실행 결과\n"),
    WINNER_ANNOUNCEMENT("최종 우승자 : "),
    ILLEGAL_INPUT_ANNOUNCEMENT("입력 형식이 잘못되었습니다\n");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }

    public String getMessage() {
        return message;
    }
}
