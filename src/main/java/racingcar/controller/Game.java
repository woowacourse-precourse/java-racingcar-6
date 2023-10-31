package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private static final String GET_RESULT_STRING = "실행 결과";
    private static final String FINAL_WINNER_STRING = "최종 우승자 : ";
    private List<Car> racingCars;

    public void start() {
        OutputView.printStartMessage();
        Cars racingCars = new Cars(InputView.getRacingCars());
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber();
        OutputView.printString(GET_RESULT_STRING);
        for (int i = 0; i < tryNumber; i++) {
            racingCars.run();
            System.out.println();
        }

        OutputView.printString(getWinnerString(racingCars.getWinners()));
    }

    private static String getWinnerString(List<String> winners) {
        if (winners.size() <1) {
            return "최종 우승자가 없습니다!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNER_STRING);
        String result = String.join(", ", winners);
        sb.append(result);
        return sb.toString();
    }
}