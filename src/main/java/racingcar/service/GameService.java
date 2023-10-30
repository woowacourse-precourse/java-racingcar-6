package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.CarValidator;
import racingcar.validator.RoundValidator;

public class GameService {

    public Game createGame(List<Car> participantCars) {
        return new Game(participantCars);
    }

    public List<Car> setupParticipantCars(List<String> carNameList) {
        return carNameList.stream()
            .peek(CarValidator::validateNameLength)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int setupRounds(String input) {
        RoundValidator.validateRounds(input);
        return Integer.parseInt(input);
    }

    public void controlCar(Game game) {
        game.moveCar();
    }
}
