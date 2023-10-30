package racingcar.config;

import racingcar.domain.Billboard;
import racingcar.domain.BillboardImpl;
import racingcar.domain.CarRegistration;
import racingcar.domain.CarRegistrationImpl;

public class AppConfig {

    private static final CarRegistration carRegistration = new CarRegistrationImpl();
    private static final Billboard billboard = new BillboardImpl();

    public static CarRegistration carRegistration() {
        return carRegistration;
    }

    public static Billboard billboard() {
        return billboard;
    }
}
