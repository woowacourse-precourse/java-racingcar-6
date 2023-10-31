package racingcar.domain;

import racingcar.config.GameConfig;
import racingcar.dto.GameResultDto;
import racingcar.dto.GameSettingDto;
import racingcar.dto.RoundResultDto;
import racingcar.dto.CarStateDto;
import racingcar.utils.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final NumberGenerator numberGenerator;
    private List<Car> cars;

    public RacingCarGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void initialize(GameSettingDto gameSettingDto) {
        this.cars = createCarsFromNames(gameSettingDto.getCarNames());
    }

    public RoundResultDto playRound() {
        List<CarStateDto> carStates = new ArrayList<>();
        for (Car car : cars) {
            boolean shouldMove = determineMovement();
            car.move(shouldMove);
            carStates.add(new CarStateDto(car.toString()));
        }
        return new RoundResultDto(carStates);
    }

    private boolean determineMovement() {
        return numberGenerator.generate(
                GameConfig.START_OF_RANGE.getValue(), GameConfig.END_OF_RANGE.getValue()
        ) >= GameConfig.FORWARD_CONDITION.getValue();
    }

    public GameResultDto getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return new GameResultDto(winnerNames);
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
