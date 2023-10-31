package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.GameInputView;

import java.util.List;

public class GameService {

    GameInputView gameInputView = new GameInputView();
    Parser parser = new Parser();
    CarRepository carRepository = new CarRepository();

    public void setGame() {
        setCars();
    }

    private void setCars() {
        List<String> carNames = parser.parseCarInput(gameInputView.getCarInput());
        for(String name : carNames) {
            carRepository.save(new Car(name));
        }
    }
}
