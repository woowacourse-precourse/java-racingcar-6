package racingcar.controller;

import java.util.Map;
import racingcar.view.outputview.OutputView;

public class DisplayRoundController extends AbstractController {
    private final OutputView outputView;

    public DisplayRoundController(final OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);
    }
}
