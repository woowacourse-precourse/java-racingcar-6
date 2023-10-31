package racingcar.view;

import racingcar.model.Cars;
import racingcar.util.NumberGenerator;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void play(Cars cars, int count, NumberGenerator numberGenerator) {
        System.out.println(GAME_RESULT);
        for (int i = 0; i < count; i++) {
            cars.forward(numberGenerator);
            System.out.println(cars.result());
            System.out.println();
        }
    }

    public void printWinner(Cars cars) {
        System.out.print(WINNER);
        System.out.println(cars.judgeWinner());
    }


}
