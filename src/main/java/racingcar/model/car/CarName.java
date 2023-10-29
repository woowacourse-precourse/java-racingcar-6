package racingcar.model.car;

import Config.AppConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record CarName(String name) {

    public CarName {
        validateName(name);
    }

    private void validateName(String carName) {
        Pattern pattern = Pattern.compile(AppConfig.CAR_NAME_FORMAT_REGEX);
        Matcher matcher = pattern.matcher(carName);
        if (matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException("이름은 공백, 숫자, 콤마(,)를 제외한 특수문자가 포함될 수 없습니다.");
    }
}
