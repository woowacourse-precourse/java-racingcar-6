package racingcar.view;

import racingcar.dto.response.RoundResultDto;

public class OutputView {
    private static final String ONE_STEP = "-";

    public void printRoundResult(RoundResultDto roundResultDto) {
        String carName = roundResultDto.name();
        int carLocation = roundResultDto.location();
        System.out.println(carName + ":" + printOneStepPosition(carLocation));
    }

    private String printOneStepPosition(int location) {
        return ONE_STEP.repeat(location);
    }
}
