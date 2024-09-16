package racingcar;

public enum MESSAGE {

    INPUT_CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)") ,
    INPUT_TRYS("시도할 회수는 몇회인가요?"),
    COLON("\" : \""),
    MOVING("-"),
    VALID_LENGTH("이름의 길이는 5 이하이어야 합니다."),
    VALID_COUNT("시도 횟수는 1 이상이어야 합니다.");

    private String message;

    MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
