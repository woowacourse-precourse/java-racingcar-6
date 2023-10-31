package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.utils.Parser;
import racingcar.view.GameInputView;

import java.util.List;

public class GameService {

    GameInputView gameInputView = new GameInputView();
    Parser parser = new Parser();
    CarRepository carRepository = new CarRepository();
    GameRepository gameRepository = new GameRepository();

    public void setGame() {
        setCars();
        setTrials();
    }

    private void setCars() {
        List<String> carNames = parser.parseCarInput(gameInputView.getCarInput());
        for(String name : carNames) {
            carRepository.save(new Car(name));
        }
    }

    private void setTrials() {
        int trial = parser.parseTrialInput(gameInputView.getTrialInput());
        gameRepository.save(new Game(carRepository.findAll(), trial));
    }
}
