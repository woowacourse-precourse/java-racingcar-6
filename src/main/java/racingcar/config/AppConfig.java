package racingcar.config;

import racingcar.domain.Billboard;
import racingcar.domain.BillboardImpl;
import racingcar.domain.CarRegistration;
import racingcar.domain.CarRegistrationImpl;
import racingcar.domain.GasolineProvider;
import racingcar.domain.RandomGasolineProvider;
import racingcar.util.InputHandler;
import racingcar.util.InputHandlerImpl;

public class AppConfig {

    private static final InputHandler inputHandler = new InputHandlerImpl();
    private static final CarRegistration carRegistration = new CarRegistrationImpl();
    private static final Billboard billboard = new BillboardImpl();
    private static final GasolineProvider gasolineProvider = new RandomGasolineProvider();

    public static InputHandler inputHandler() {
        return inputHandler;
    }

    public static CarRegistration carRegistration() {
        return carRegistration;
    }

    public static Billboard billboard() {
        return billboard;
    }

    public static GasolineProvider gasolineProvider() {
        return gasolineProvider;
    }
}
