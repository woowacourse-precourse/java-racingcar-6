package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;

public class GameController {

    private final RandomNumberGenerator numberGenerator;

    public GameController(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        // 게임 초기 설정
        List<Car> cars = createCars();
        int numberOfAttempts = InputView.readNumberOfAttempts();

        // 게임 진행
    }

    private List<Car> createCars() {
        List<String> carNames = InputView.readCarNames();
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
