package racingcar.controller;

import java.util.Map;
import racingcar.view.outputview.ErrorOutputView;
import racingcar.view.outputview.OutputView;

public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorOutputView();
    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    abstract void doProcess(Map<String, Object> model);
}
