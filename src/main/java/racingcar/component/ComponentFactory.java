package racingcar.component;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.utils.CarNameSeperator;
import racingcar.utils.JudgementRandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ComponentFactory {

    public RacingCarController racingCarController() {
        return new RacingCarController(outputView(), inputView(), racingCarService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RacingCarService racingCarService() {
        return new RacingCarService(carNameSeperator(), judgementRandomGenerator());
    }

    private CarNameSeperator carNameSeperator() {
        return new CarNameSeperator();
    }

    private JudgementRandomGenerator judgementRandomGenerator() {
        return new JudgementRandomGenerator();
    }
}
