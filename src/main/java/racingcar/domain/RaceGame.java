package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarRegistrationDTO;
import racingcar.dto.RaceProgressDTO;
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
        List<String> nameAndDistanceMessages = new ArrayList<>();
        while (remainRoundCount-- > MIN_ROUND_COUNT) {
            tryDriveCarsByGasolineProvider(cars, gasolineProvider);
            nameAndDistanceMessages.add(geNameAndDistanceMessagesOfRound(cars));
        }

        billboard.displayraceprogress(new RaceProgressDTO(nameAndDistanceMessages));
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

    private String geNameAndDistanceMessagesOfRound(List<Car> cars) {
        return cars.stream()
                .map(Car::generateNameAndDistanceMessage)
                .collect(Collectors.joining());
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
