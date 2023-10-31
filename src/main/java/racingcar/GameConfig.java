package racingcar;

import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.view.TerminalView;
import racingcar.view.View;

/**
 * DI 관련 설정 클래스
 * 시작시 view, service 구현체를 GameController 에 주입
 */
public class GameConfig {

    public GameController run() {
        return new GameController(view(), carService());
    }

    public View view() {
        return new TerminalView();
    }

    public CarService carService() {
        return new CarServiceImpl(carRepository());
    }

    public CarRepository carRepository() {
        return new CarRepositoryImpl();
    }
}
