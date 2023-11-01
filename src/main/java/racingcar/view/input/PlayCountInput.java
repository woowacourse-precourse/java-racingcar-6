package racingcar.view.input;

import java.util.regex.Pattern;

public class PlayCountInput {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private final int playCount;

    private PlayCountInput(int playCount) {
        this.playCount = playCount;
    }

    public static PlayCountInput parse(String input) {
        validateNumber(input);
        return new PlayCountInput(Integer.parseInt(input));
    }

    private static void validateNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    public int playCount() {
        return playCount;
    }
}
