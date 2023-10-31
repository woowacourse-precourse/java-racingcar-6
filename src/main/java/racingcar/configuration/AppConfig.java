package racingcar.configuration;

import racingcar.controller.RacingController;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.repository.MemoryRacingRepository;
import racingcar.repository.RacingRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig implements Config { //IoC Container
    //AppConfig를 싱글톤으로 두면 전체 프로그램에서 아래 객체들도 싱글톤으로 관리 가능, 대신 test할 때 조금 불편함
    private CarRepository carRepository;
    private RacingRepository racingRepository;
    private CarService carService;
    private RacingService racingService;
    private InputView inputView;
    private OutputView outputView;
    private RacingController racingController;

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
    public RacingRepository racingRepository() {
        if (racingRepository == null) {
            racingRepository = new MemoryRacingRepository();
        }
        return racingRepository;
    }

    @Override
    public CarService carService() {
        if (carService == null) {
            carService = new CarServiceImpl(carRepository());
        }
        return carService;
    }

    @Override
    public RacingService racingService() {
        if (racingService == null) {
            racingService = new RacingServiceImpl(carRepository(), racingRepository());
        }
        return racingService;
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
    public RacingController racingController() {
        if (racingController == null) {
            racingController = new RacingController(inputView(), outputView(), racingService());
        }
        return racingController;
    }
}
