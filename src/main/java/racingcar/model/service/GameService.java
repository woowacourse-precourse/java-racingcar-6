package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;

public class GameService {
    private final int NAME_LENGTH = 5;
    CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(List<String> carNames) {
        carNames.forEach(name -> carRepository.save(name));
    }

    public void nameCheck(List<String> carNames) {
        carNames.forEach(car -> {
            if (car.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다");
            }
        });
    }

    public Car playGame(int idx) {
        return carRepository.carForward(idx, Randoms.pickNumberInRange(0, 9));
    }

    public List<String> resultGame() {
        return carRepository.findAllMaxForward();
    }
}
