package strings.util;

public final class Strings {
    public static final String DASH = "-";
    public static final String LINE_BREAK = "\n";
    public static final String COMMAS = ",";
    public static final String WHITE_SPACE = " ";

    private Strings() {
    }

    public static String repeat(
            final String str,
            final int count
    ) {
        if (count < 0) {
            throw new IllegalArgumentException("반드시 0회 이상 반복해야 합니다.");
        }
        StringValidator.validateString(str);
        return str
                .repeat(count);
    }
}
