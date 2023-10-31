package racingcar.util;

// 게임 과정에서 사용자에게 출력한 메세지를 관리하는 열거형 클래스
public enum GameDefaultMessage {
    MESSAGE_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MESSAGE_INPUT_FREQUENCY("시도할 회수는 몇회인가요?"),
    MESSAGE_GAME_RESULT("실행 결과"),
    MESSAGE_GAME_WINNER("최종 우승자 : ")
    ;

    private final String message;

    GameDefaultMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}