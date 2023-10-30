package racingcar.config;

import racingcar.domain.CarRegistration;
import racingcar.domain.CarRegistrationImpl;

public class AppConfig {

    private static final CarRegistration carRegistration = new CarRegistrationImpl();

    public static CarRegistration carRegistration() {
        return carRegistration;
    }
}
