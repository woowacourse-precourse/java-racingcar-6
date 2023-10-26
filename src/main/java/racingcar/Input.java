package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    String inputCarName() {
        String raw = Console.readLine();
        isErrorCarName(raw);
        return raw;
    }

    private void isErrorCarName(String raw) throws IllegalArgumentException {
        if (isNull(raw)
                || isBlank(raw)
                || isLength1To(raw, 5)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNull(String raw) {
        return raw == null;
    }

    private boolean isBlank(String raw) {
        return raw.compareTo("") == 0;
    }

    private boolean isLength1To(String raw, int length) {
        return raw.length() <= length;
    }
}
