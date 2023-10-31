package racingcar.view;

import static racingcar.constant.Constant.END_WINNER_MESSAGE;
import static racingcar.constant.Constant.MOVE_CHAR;
import static racingcar.constant.Constant.SEPARATOR_CHAR;
import static racingcar.constant.Constant.START_GAME_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.RacingCars;

public final class OutputView {

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printCarsPosition(RacingCars racingCars) {
        racingCars.getCars().forEach(car ->
                System.out.println(car.getName() + " : " + convertPositionToString(car.getPosition()))
        );
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.print(END_WINNER_MESSAGE);
        String winnerNames = winner.stream()
                .collect(Collectors.joining(SEPARATOR_CHAR));

        System.out.print(winnerNames);
    }

    private static String convertPositionToString(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> MOVE_CHAR)
                .collect(Collectors.joining());
    }
}
