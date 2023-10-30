package racingcar.view.output;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.car.Car;
import racingcar.view.output.dto.RacingStateDto;
import racingcar.view.output.dto.WinnersDto;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String RACING_STATE_FORMAT = "%s : %s\n";
    private static final String FINAL_WINNERS_FORMAT = "최종 우승자 : %s";
    private static final int ZERO = 0;
    private static final String BAR = "-";
    private static final String COMMA_AND_SPACE = ", ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRacingState(RacingStateDto racingStateDto) {
        Map<String, Integer> state = racingStateDto.state();

        String message = state.keySet().stream()
            .map(name -> String.format(RACING_STATE_FORMAT, name, toBar(state.get(name))))
            .collect(Collectors.joining());

        System.out.println(message);
    }

    private static String toBar(int movement) {
        return IntStream.range(ZERO, movement)
            .mapToObj(it -> BAR)
            .collect(Collectors.joining());
    }

    public static void printWinners(WinnersDto winnersDto) {
        String message = String.format(FINAL_WINNERS_FORMAT, toNames(winnersDto.winners()));
        System.out.println(message);
    }

    private static String toNames(List<Car> winningCars) {
        return winningCars.stream()
            .map(car -> car.name())
            .collect(Collectors.joining(COMMA_AND_SPACE));
    }
}
