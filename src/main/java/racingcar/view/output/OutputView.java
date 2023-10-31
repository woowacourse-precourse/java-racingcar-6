package racingcar.view.output;

import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.ENTER;
import static racingcar.constant.Constant.EXECUTION_RESULT_MENT;
import static racingcar.constant.Constant.MINUS_SIGN;

import java.util.List;
import racingcar.dto.RacingCarDto;

public class OutputView {

    public void printExecutionResultMent() {
        System.out.println(EXECUTION_RESULT_MENT);
    }

    public void printExecutionResult(List<RacingCarDto> executionResult) {
        System.out.println(renderResult(executionResult));
    }

    private String renderResult(List<RacingCarDto> executionResult) {
        StringBuilder renderer = new StringBuilder();
        executionResult.forEach(result -> {
            renderer.append(result.getCarName()).append(COLON);
            renderer.append(MINUS_SIGN.repeat(Math.max(0, result.getPosition()))).append(ENTER);
        });
        return renderer.toString();
    }
}
