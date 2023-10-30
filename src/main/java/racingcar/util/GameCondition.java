package racingcar.util;

// 게임의 제약 조건들을 관리하기 위한 열거형 클래스
public enum GameCondition {
    CONDITION_INPUT_MAX_LENGTH(5),
    CONDITION_INPUT_MIN_LENGTH(1),
    CONDITION_FORWARD_VALUE(4)
    ;
    private final int condition;

    public int getCondition() {
        return this.condition;
    }

    GameCondition(int condition) {
        this.condition = condition;
    }
}
