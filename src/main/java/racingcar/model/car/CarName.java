package racingcar.model.car;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.config.InputConfig;

public record CarName(String name) {
    public CarName {
        validateName(name);
    }

    private void validateName(String input) {
        Pattern pattern = Pattern.compile(InputConfig.NAME_FORMAT);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return;
        }

        throw new IllegalArgumentException("영문으로만 이루어진 " +
                InputConfig.NAME_LENGTH_MIN + "이상 " +
                InputConfig.NAME_LENGTH_MAX + "이하의 이름을" +
                InputConfig.NAME_DELIMITER + "로 구분하여 입력하세요.");
    }
}
