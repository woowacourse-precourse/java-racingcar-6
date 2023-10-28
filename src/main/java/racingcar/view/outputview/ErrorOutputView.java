package racingcar.view.outputview;

import java.util.Map;

public class ErrorOutputView implements OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";

    @Override
    public void print(Map<String, Object> model) {
        // Error Enum으로 반영하기
        String errorMessage = (String) model.get("errorMessage");
        System.out.printf("%s %s\n", ERROR_PREFIX, errorMessage);
    }
}
