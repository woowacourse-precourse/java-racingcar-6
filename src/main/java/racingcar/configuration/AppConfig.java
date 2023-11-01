package racingcar.configuration;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.repository.MemoryRacingGameRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * AppConfig 클래스는 IoC(Inversion of Control) 컨테이너 역할을 하며 의존성 주입을 관리합니다.
 * AppConfig를 싱글톤으로 두면 전체 프로그램에서 멤버 객체들도 싱글톤으로 관리합니다.
 */
public class AppConfig implements Config {

    private CarRepository carRepository;
    private RacingGameRepository racingGameRepository;
    private RacingGameService racingGameService;
    private InputView inputView;
    private OutputView outputView;
    private RacingGameController racingGameController;

    private static AppConfig appConfig;

    /**
     * AppConfig의 인스턴스를 반환하는 메소드입니다.
     * appConfig 인스턴스가 없는 경우에만 새로운 인스턴스를 생성하는 싱글톤 방식을 사용합니다.
     *
     * @return AppConfig의 싱글톤 인스턴스
     */
    public static AppConfig getInstance() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    /**
     * CarRepository를 반환하는 메소드입니다. CarRepository는 자동차 관련 데이터를 저장하고 관리합니다.
     *
     * @return CarRepository 인스턴스
     */
    @Override
    public CarRepository carRepository() {
        if (carRepository == null) {
            carRepository = new MemoryCarRepository();
        }
        return carRepository;
    }

    /**
     * RacingGameRepository를 반환하는 메소드입니다. RacingGameRepository는 레이싱 게임 관련 데이터를 저장하고 관리합니다.
     *
     * @return RacingGameRepository 인스턴스
     */
    @Override
    public RacingGameRepository racingRepository() {
        if (racingGameRepository == null) {
            racingGameRepository = new MemoryRacingGameRepository();
        }
        return racingGameRepository;
    }

    /**
     * RacingGameService를 반환하는 메소드입니다. RacingGameService는 레이싱 게임의 비지니스 로직을 구현합니다.
     * RacingGameServiceImpl 인스턴스를 생성하기 위해선 racingRepository의 인스턴스가 필요합니다.
     * racingRepository의 인스턴스를 얻기 위해 racingRepository() 메서드를 호출하여 싱글톤 인스턴스를 얻습니다.
     *
     * @return RacingGameService 인스턴스
     */
    @Override
    public RacingGameService racingService() {
        if (racingGameService == null) {
            racingGameService = new RacingGameServiceImpl(racingRepository());
        }
        return racingGameService;
    }

    /**
     * InputView를 반환하는 메소드입니다. InputView는 사용자 입력을 처리합니다.
     *
     * @return InputView 인스턴스
     */
    @Override
    public InputView inputView() {
        if (inputView == null) {
            inputView = new ConsoleInputView();
        }
        return inputView;
    }

    /**
     * OutputView를 반환하는 메소드입니다. OutputView는 결과를 출력합니다.
     *
     * @return OutputView 인스턴스
     */
    @Override
    public OutputView outputView() {
        if (outputView == null) {
            outputView = new ConsoleOutputView();
        }
        return outputView;
    }

    /**
     * RacingGameController를 반환하는 메소드입니다. RacingGameController는 게임 흐름을 제어합니다.
     *
     * @return RacingGameController 인스턴스
     */
    @Override
    public RacingGameController racingController() {
        if (racingGameController == null) {
            racingGameController = new RacingGameController(inputView(), outputView(), racingService());
        }
        return racingGameController;
    }
}
