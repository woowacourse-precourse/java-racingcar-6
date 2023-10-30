package racingcar.view;

import java.util.List;
import racingcar.domain.CarList.CarDto;

public class OutputView {

    private final static String RACING_RESULT = "실행 결과";
    private final static String NEXT_LINE = "/n";

    public void printResult() {
        System.out.println(RACING_RESULT);
    }

    public void printRoundResult(List<CarDto> carDtos) {
        StringBuilder sb = new StringBuilder();
        for (CarDto carDto : carDtos) {
            sb.append(carDto.carName()).append(" : ")
                .append("-".repeat(carDto.position()))
                .append(NEXT_LINE);
        }
        sb.append(NEXT_LINE);
        System.out.println(sb);
    }
}
