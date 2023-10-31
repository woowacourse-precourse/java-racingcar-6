package racingcar.view;

import java.util.List;
import racingcar.controller.dto.ResponseDto;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printGameResult(String result) {
        System.out.print(result);
    }
}
