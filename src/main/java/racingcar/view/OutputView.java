package racingcar.view;

import java.util.List;
import racingcar.controller.dto.ResponseDto;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printOneGame(ResponseDto responseDto) {
        List<String> results = responseDto.getResults();
        for (String s : results) {
            System.out.println(s);
        }
    }
}
