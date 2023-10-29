package racingcar.domain;

import racingcar.global.ErrorMessage;
import racingcar.global.RaceException;

import java.util.regex.Pattern;

public class PlayIterator {
    private int count;

    public PlayIterator(int count) {
        this.count = count;
    }

    public static PlayIterator from(String playCountStr) {
        validateNumericString(playCountStr.trim());
        return new PlayIterator(Integer.parseInt(playCountStr.trim()));
    }

    private static void validateNumericString(String playCountStr) {
        if (!Pattern.compile("\\d+").matcher(playCountStr).matches()) {
            throw RaceException.of(ErrorMessage.NOT_NUMERIC_PLAY_COUNT_STRING);
        }
    }

    public boolean isPlayable() {
        return count > 0;
    }

    public void play() {
        count--;
    }
}
