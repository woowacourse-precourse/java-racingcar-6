package racingcar.view;

import racingcar.model.Cars;
import racingcar.util.Converter;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void printResultGuide() {
        System.out.println(GAME_RESULT);
    }

    public void printResults(Cars cars) {
        System.out.println(Converter.formatCarsResult(cars));
    }

    public void printWinners(Cars cars) {
        System.out.println();
        System.out.print(WINNER);
        Cars winner = cars.judgeWinner();
        System.out.println(Converter.formatWinnersResult(winner));
    }
}
