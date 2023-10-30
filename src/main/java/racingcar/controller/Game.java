package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private static final String GET_RESULT_STRING = "실행 결과";
    private static final String FINAL_WINNER_STRING = "최종 우승자 : ";

    public void start() {
        OutputView.printStartMessage();
        Cars racingCars = Cars.createCars(InputView.getRacingCars());
        Race race = Race.createRace(racingCars);
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber();
        OutputView.printString(GET_RESULT_STRING);
        for (int i = 0; i < tryNumber; i++) {
            race.run();
            System.out.println();
        }

        System.out.println(getWinnerString(race.getWinners()));
    }

    private static String getWinnerString(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNER_STRING);
        for (Car car : winners) {
            sb.append(car.getName());
        }
        return sb.toString();
    }
}