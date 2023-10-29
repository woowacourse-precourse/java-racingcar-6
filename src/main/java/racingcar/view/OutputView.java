package racingcar.view;

import racingcar.domain.RacingCars;
import racingcar.domain.Winner;

import java.util.stream.IntStream;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String HYPHEN = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String RACING_CAR_NAME = "%s : ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printMoveRacingCar(RacingCars racingCars) {

        racingCars.getRacingCars().stream().forEach(v -> {
                    System.out.print(String.format(RACING_CAR_NAME,v.getName()));
                    IntStream.range(0, v.getMove()).forEach(num -> {
                        System.out.print(HYPHEN);
                    });
                    System.out.println();
                }
        );
    }

    public static void printWinner(Winner winner) {
        System.out.print(String.format(WINNER_MESSAGE, winner.getWinnerRacingCar()));
    }
}
