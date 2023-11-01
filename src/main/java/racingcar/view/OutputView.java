package racingcar.view;

import java.util.List;
import racingcar.domain.CarList.CarDto;

public class OutputView {

    private final static String RACING_RESULT = "실행 결과";
    private final static String WINNER = "최종 우승자";
    private final static String NEXT_LINE = "\n";
    private final static String MOVE_STRING = "-";
    private final static String STRING_FORMAT_DIVIDE = " : ";
    private final static String STRING_FORMAT_SPLIT = ", ";

    public void printResult() {
        System.out.println(RACING_RESULT);
    }

    public void printRoundResult(List<CarDto> carDtoList) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for (CarDto car : carDtoList) {
            sb.append(car.carName()).append(STRING_FORMAT_DIVIDE)
                .append(MOVE_STRING.repeat(car.position()))
                .append(NEXT_LINE);
        }
        System.out.println(sb);
    }

    public void printWinner(List<String> winners) {
        String winner = String.join(STRING_FORMAT_SPLIT, winners);
        System.out.println(WINNER + STRING_FORMAT_DIVIDE + winner);
    }
}
