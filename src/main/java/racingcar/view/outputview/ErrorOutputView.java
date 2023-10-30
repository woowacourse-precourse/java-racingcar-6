package racingcar.view.outputview;

import java.util.Map;
import racingcar.controller.AbstractController;

public class ErrorOutputView implements OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String ERROR_FORMAT = "%s %s\n";

    @Override
    public void print(Map<String, Object> model) {
        String errorMessage = (String) model.get(AbstractController.ERROR_MESSAGE_KEY);
        System.out.printf(ERROR_FORMAT, ERROR_PREFIX, errorMessage);
    }
}
