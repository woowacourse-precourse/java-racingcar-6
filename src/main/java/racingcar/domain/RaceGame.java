package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.dto.CarRegistrationDTO;
import racingcar.dto.RaceProgressDTO;
import racingcar.util.InputHandler;

public class RaceGame {

    private final InputHandler inputHandler;
    private final CarRegistration carRegistration;
    private final Billboard billboard;
    private final GasolineProvider gasolineProvider;

    private RaceGame(InputHandler inputHandler, CarRegistration carRegistration, Billboard billboard,
            GasolineProvider gasolineProvider) {
        this.inputHandler = inputHandler;
        this.carRegistration = carRegistration;
        this.billboard = billboard;
        this.gasolineProvider = gasolineProvider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void play() {
        List<Car> cars = registerCars();
        int remainRoundCount = inputHandler.getRaceRoundCount();
        RaceProgressDTO raceProgressDTO = playRoundsAndCollectRaceProgress(cars, remainRoundCount);
        billboard.displayraceprogress(raceProgressDTO);
        billboard.displayWinners(getWinnerStand(cars));
    }

    private RaceProgressDTO playRoundsAndCollectRaceProgress(List<Car> cars, int roundCount) {
        int currentRound = 0;
        List<String> nameAndDistanceMessages = new ArrayList<>();
        while (currentRound++ < roundCount) {
            tryDriveCarsByGasolineProvider(cars, gasolineProvider);
            nameAndDistanceMessages.add(getNameAndDistanceMessageOfRound(cars));
        }

        return new RaceProgressDTO(nameAndDistanceMessages);
    }

    private List<Car> registerCars() {
        List<CarRegistrationDTO> carRegistrationDTOS = inputHandler.getCarRegistrations();
        return carRegistration.register(carRegistrationDTOS);
    }

    private void tryDriveCarsByGasolineProvider(List<Car> cars, GasolineProvider gasolineProvider) {
        for (Car car : cars) {
            int gasoline = gasolineProvider.provide();
            car.tryDrive(gasoline);
        }
    }

    private String getNameAndDistanceMessageOfRound(List<Car> cars) {
        return cars.stream()
                .map(Car::generateNameAndDistanceMessage)
                .collect(Collectors.joining());
    }

    private WinnerStand getWinnerStand(List<Car> cars) {
        int winnerDistance = Car.getMaxDistanceAmongCars(cars);
        WinnerStand winnerStand = new WinnerStand();
        for (Car car : cars) {
            if (car.matchesDrivenDistance(winnerDistance)) {
                car.standAsWinner(winnerStand);
            }
        }

        return winnerStand;
    }

    public static class Builder {

        private InputHandler inputHandler;
        private CarRegistration carRegistration;
        private Billboard billboard;
        private GasolineProvider gasolineProvider;

        public Builder inputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        public Builder carRegistration(CarRegistration carRegistration) {
            this.carRegistration = carRegistration;
            return this;
        }

        public Builder billboard(Billboard billboard) {
            this.billboard = billboard;
            return this;
        }

        public Builder gasolineProvider(GasolineProvider gasolineProvider) {
            this.gasolineProvider = gasolineProvider;
            return this;
        }

        public RaceGame build() {
            validateFields();
            return new RaceGame(inputHandler, carRegistration, billboard, gasolineProvider);
        }

        private void validateFields() {
            Objects.requireNonNull(inputHandler, "InputHandler should not be null");
            Objects.requireNonNull(carRegistration, "CarRegistration should not be null");
            Objects.requireNonNull(billboard, "Billboard should not be null");
            Objects.requireNonNull(gasolineProvider, "GasolineProvider should not be null");
        }
    }
}
