package racingcar.domain;

import java.util.List;
import racingcar.dto.CarRegistrationDTO;
import racingcar.util.InputHandler;

public class RaceGame {

    private static final int MIN_ROUND_COUNT = 0;

    private final InputHandler inputHandler;
    private final CarRegistration carRegistration;
    private final Billboard billboard;

    private RaceGame(InputHandler inputHandler, CarRegistration carRegistration, Billboard billboard) {
        this.inputHandler = inputHandler;
        this.carRegistration = carRegistration;
        this.billboard = billboard;
    }

    public void play() {
        List<Car> cars = registerCars();
        RandomGasolineProvider gasolineProvider = new RandomGasolineProvider();
        int remainRoundCount = inputHandler.getRaceRoundCount();

        while (remainRoundCount-- > MIN_ROUND_COUNT) {
            tryDriveCarsByGasolineProvider(cars, gasolineProvider);
        }
    }

    private List<Car> registerCars() {
        List<CarRegistrationDTO> carRegistrationDTOS = inputHandler.getCarRegistrations();
        return carRegistration.register(carRegistrationDTOS);
    }

    private void tryDriveCarsByGasolineProvider(List<Car> cars, RandomGasolineProvider gasolineProvider) {
        for (Car car : cars) {
            int gasoline = gasolineProvider.provide();
            car.tryDrive(gasoline);
        }
    }

    public static class Builder {

        private InputHandler inputHandler;
        private CarRegistration carRegistration;
        private Billboard billboard;

        public Builder withInputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        public Builder withCarRegistration(CarRegistration carRegistration) {
            this.carRegistration = carRegistration;
            return this;
        }

        public Builder withBillboard(Billboard billboard) {
            this.billboard = billboard;
            return this;
        }

        public RaceGame build() {
            return new RaceGame(inputHandler, carRegistration, billboard);
        }
    }
}
