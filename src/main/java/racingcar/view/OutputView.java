package racingcar.view;

import java.util.List;
import racingcar.dto.response.GameResultDto;
import racingcar.dto.response.RoundResultDto;

public class OutputView {
    private static final String ONE_STEP = "-";
    private static final String RESULT_MESSAGE = "최종 우승자";
    private static final String COLON = " : ";

    public void printRoundResult(RoundResultDto roundResultDto) {
        String carName = roundResultDto.name();
        int carLocation = roundResultDto.location();
        System.out.println(carName + COLON + printOneStepPosition(carLocation));
    }

    private String printOneStepPosition(int location) {
        return ONE_STEP.repeat(location);
    }

    public void printGameResult(GameResultDto gameResultDto) {
        System.out.println(RESULT_MESSAGE + COLON + joinNames(gameResultDto.winners()));
    }

    private String joinNames(List<String> nameList) {
        return String.join(", ", nameList);
    }
}
