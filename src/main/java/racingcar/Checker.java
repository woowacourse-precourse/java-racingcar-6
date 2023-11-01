package racingcar;
import java.util.*;

public class Checker {

    public static void checkValidTurn(int turn) {
        try {
            if (turn <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 정수가 아닙니다.");
        }
    }
}
