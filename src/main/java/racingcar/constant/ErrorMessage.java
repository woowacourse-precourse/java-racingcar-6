package racingcar.constant;

public enum ErrorMessage {
    INPUT_NOT_FORMAT("자동차 이름을 다음과 같은 형태: (이름1, 이름2, 이름3) 과 같은 형태로 넣어주셔야합니다!"),
    INPUT_GAME_COUNT_EXCEPTION("게임 횟수는 숫자가 와야 합니다!"),
    INPUT_CAR_NAME_LENGTH_EXCEPTION("자동차 이름의 길이는 %d이하이여야 합니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
