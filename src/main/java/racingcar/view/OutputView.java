package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String DELIMITER = " : ";
    private static final String HYPHEN = "-";
    private static final String NEXT_LINE = "\n";
    private static final String WINNER = "최종 우승자 : %s";
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printResultMessage() {
        System.out.println(RESULT);
    }

    public void printRacingResult(final List<CarDto> carList) {
        final StringBuilder sb = new StringBuilder();
        for (final CarDto car : carList) {
            sb.append(car.name());
            sb.append(DELIMITER);
            sb.append(HYPHEN.repeat(car.position()));
            sb.append(NEXT_LINE);
        }
        System.out.println(sb);
    }

    public void printWinners(final List<CarDto> winnerList) {
        final String winners = winnerList.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(", "));
        final String format = String.format(WINNER, winners);
        System.out.println(format);
    }
}
