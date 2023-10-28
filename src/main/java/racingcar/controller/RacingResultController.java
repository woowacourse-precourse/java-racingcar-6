package racingcar.controller;

import java.util.Map;
import racingcar.view.outputview.OutputView;

public class RacingResultController extends AbstractController {
    private final OutputView outputView;

    public RacingResultController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);
    }
}
