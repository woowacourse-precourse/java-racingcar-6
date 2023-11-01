package racingcar.factory;

import racingcar.constant.ErrorMessage;
import racingcar.controller.RacingCarController;
import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.io.InputManager;
import racingcar.io.InputMapper;
import racingcar.io.InputValidator;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.repository.DomainRepository;
import racingcar.service.RacingCarService;
import racingcar.utils.RandomNumberGenerator;

public final class ComponentFactory {

    private final RacingCarController racingCarController;

    private ComponentFactory() {
        this.racingCarController =
                new RacingCarController(outputView(), inputManager(), racingCarService());
    }

    private static final class ComponentFactoryHolder {

        private static final ComponentFactory INSTANCE = new ComponentFactory();

        private ComponentFactoryHolder() {
            throw new IllegalStateException(ErrorMessage.INVALID_CONSTRUCTOR.toValue());
        }
    }

    public static ComponentFactory getInstance() {
        return ComponentFactoryHolder.INSTANCE;
    }

    public RacingCarController racingCarController() {
        return this.racingCarController;
    }

    private RacingCarService racingCarService() {
        return new RacingCarService(
                racingCarsRepository(), tryCountRepository(), randomNumberGenerator());
    }

    private RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private DomainRepository<RacingCars> racingCarsRepository() {
        return new DomainRepository<>();
    }

    private DomainRepository<TryCount> tryCountRepository() {
        return new DomainRepository<>();
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
