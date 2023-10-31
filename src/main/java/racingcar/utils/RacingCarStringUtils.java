package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarStringUtils {

    private RacingCarStringUtils() {
    }

    public static List<String> parseCarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public static Set<String> parseCarNamesToSet(String carNames) {
        return Arrays.stream(carNames.split(",")).collect(Collectors.toSet());
    }

    public static boolean hasText(String gameCount) {
        return gameCount != null && !gameCount.isEmpty() && containsText(gameCount);
    }

    private static boolean containsText(String gameCount) {
        for (char ch : gameCount.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                return true;
            }
        }
        return false;
    }
}
