package racingcar.util;

import java.util.List;

public class Formatter {
    private Formatter() {}

    public static Formatter getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Formatter INSTANCE = new Formatter();
    }

    public int changeToInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> splitToList(String string) {
        return List.of(string.trim().split(","));
    }
}