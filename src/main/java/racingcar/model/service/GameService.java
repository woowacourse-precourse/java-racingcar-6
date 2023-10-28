package racingcar.model.service;

import java.util.List;
import racingcar.model.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameService {
    CarRepository carRepository;

    public GameService() {
        carRepository = new CarRepository();
    }

    public void createCars() {
        List<String> names = InputView.inputName();
        names.forEach(name -> carRepository.save(name));
    }

    public void playGame() {
        int attemptNum = InputView.inputAttempt();
        OutputView.outputResult();
        while (attemptNum != 0) {
            carRepository.carForward();
            attemptNum--;
        }
    }

    public void resultGame() {
        OutputView.outputWinner(carRepository.findAllMaxForward());
    }
}
