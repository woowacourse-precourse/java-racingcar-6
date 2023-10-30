package racingcar.model.car;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.AppConfig;

public record CarName(String name) {
    public CarName {
        validateName(name);
    }

    private void validateName(String input) {
        Pattern pattern = Pattern.compile(AppConfig.NAME_FORMAT);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
