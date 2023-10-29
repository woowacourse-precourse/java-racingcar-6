package racingcar.model.service;

import java.util.List;
import racingcar.model.repository.CarRepository;

public class GameService {
    CarRepository carRepository;

    public GameService() {
        carRepository = new CarRepository();
    }

    public void createCars(List<String> names) {
        names.forEach(name -> carRepository.save(name));
    }

    public void nameCheck() {
        carRepository.validNameCheck();
    }

    public void playGame(int attemptNum) {
        while (attemptNum != 0) {
            carRepository.carForward();
            attemptNum--;
        }
    }

    public List<String> resultGame() {
        return carRepository.findAllMaxForward();
    }
}
