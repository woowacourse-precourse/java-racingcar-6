package racingcar.domain;

import java.util.List;
import racingcar.dto.CarRegistrationDTO;
import racingcar.util.InputHandler;

public class RaceGame {

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
    }

    private List<Car> registerCars() {
        List<CarRegistrationDTO> carRegistrationDTOS = inputHandler.getCarRegistrations();
        return carRegistration.register(carRegistrationDTOS);
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
