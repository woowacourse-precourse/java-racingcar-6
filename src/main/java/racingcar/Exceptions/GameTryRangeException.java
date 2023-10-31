package racingcar.Exceptions;

public class GameTryRangeException extends IllegalArgumentException {
    public GameTryRangeException() {
        super("시도할 게임 횟수는 1 - 2147483647 중 하나로 입력해야 합니다.");
    }
}
