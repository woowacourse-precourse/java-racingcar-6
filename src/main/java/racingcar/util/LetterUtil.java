package racingcar.util;

import java.util.stream.IntStream;

public class LetterUtil {

    public static String sameLetterPaste(String letter, int loopNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, loopNumber).forEach(i -> stringBuilder.append(letter));
        return stringBuilder.toString();
    }
}
