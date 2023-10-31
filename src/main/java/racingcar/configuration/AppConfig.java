package racingcar.configuration;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.repository.MemoryRacingGameRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig implements Config { //IoC Container
    //AppConfig를 싱글톤으로 두면 전체 프로그램에서 아래 객체들도 싱글톤으로 관리 가능, 대신 test할 때 조금 불편함
    private CarRepository carRepository;
    private RacingGameRepository racingGameRepository;
    private CarService carService;
    private RacingGameService racingGameService;
    private InputView inputView;
    private OutputView outputView;
    private RacingGameController racingGameController;

    private static AppConfig appConfig;
    private AppConfig() {

    }

    public static AppConfig getInstance() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    @Override
    public CarRepository carRepository() {
        if (carRepository == null) {
            carRepository = new MemoryCarRepository();
        }
        return carRepository;
    }

    @Override
    public RacingGameRepository racingRepository() {
        if (racingGameRepository == null) {
            racingGameRepository = new MemoryRacingGameRepository();
        }
        return racingGameRepository;
    }

    @Override
    public CarService carService() {
        if (carService == null) {
            carService = new CarServiceImpl(carRepository());
        }
        return carService;
    }

    @Override
    public RacingGameService racingService() {
        if (racingGameService == null) {
            racingGameService = new RacingGameServiceImpl(carService(), racingRepository());
        }
        return racingGameService;
    }

    @Override
    public InputView inputView() {
        if (inputView == null) {
            inputView = new ConsoleInputView();
        }
        return inputView;
    }

    @Override
    public OutputView outputView() {
        if (outputView == null) {
            outputView = new ConsoleOutputView();
        }
        return outputView;
    }

    @Override
    public RacingGameController racingController() {
        if (racingGameController == null) {
            racingGameController = new RacingGameController(inputView(), outputView(), racingService());
        }
        return racingGameController;
    }
}
