package racingcar.util;

public class RacingcarRoundConvertor {
    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }
}
