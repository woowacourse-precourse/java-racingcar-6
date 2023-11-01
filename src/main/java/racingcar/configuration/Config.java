package racingcar.configuration;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * Config 인터페이스는 IoC 컨테이너가 반환해야할 인스턴스들을 반환하는 메서드를 선언합니다.
 */
public interface Config {

    CarRepository carRepository();

    RacingGameRepository racingRepository();

    RacingGameService racingService();

    InputView inputView();

    OutputView outputView();

    RacingGameController racingController();
}
