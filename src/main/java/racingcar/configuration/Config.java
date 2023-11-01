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

    /**
     * CarRepository를 반환하는 메소드입니다.
     *
     * @return CarRepository 인스턴스
     */
    CarRepository carRepository();

    /**
     * RacingGameRepository를 반환하는 메소드입니다.
     *
     * @return RacingGameRepository 인스턴스
     */
    RacingGameRepository racingRepository();

    /**
     * RacingGameService를 반환하는 메소드입니다.
     *
     * @return RacingGameService 인스턴스
     */
    RacingGameService racingService();

    /**
     * InputView를 반환하는 메소드입니다.
     *
     * @return InputView 인스턴스
     */
    InputView inputView();

    /**
     * OutputView를 반환하는 메소드입니다.
     *
     * @return OutputView 인스턴스
     */
    OutputView outputView();

    /**
     * RacingGameController를 반환하는 메소드입니다.
     *
     * @return RacingGameController 인스턴스
     */
    RacingGameController racingController();
}
