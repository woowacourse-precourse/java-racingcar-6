package racingcar.view;

import java.util.List;
import racingcar.domain.CarList.CarDto;

public class OutputView {

    private final static String RACING_RESULT = "실행 결과";
    private final static String WINNER = "최종 우승자";
    private final static int SOLO_WINNER = 1;
    private final static String NEXT_LINE = "\n";
    private final StringBuilder sb = new StringBuilder();

    public void printResult() {
        System.out.println(RACING_RESULT);
    }

    public void printRoundResult(List<CarDto> carDtoList) {
        sb.setLength(0);
        for (CarDto car : carDtoList) {
            sb.append(car.getCarName()).append(" : ")
                .append("-".repeat(car.getPosition()))
                .append(NEXT_LINE);
        }
        System.out.println(sb);
    }

    public void printWinner(List<String> winners) {
        sb.setLength(0);
        sb.append(WINNER).append(" : ");
        if (winners.size() == SOLO_WINNER) {
            sb.append(winners);
            System.out.println(sb);
            return;
        }
        for (String winner : winners) {
            sb.append(winner).append(", ");
        }
        System.out.println(sb);
    }
}
