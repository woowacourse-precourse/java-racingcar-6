package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        Cars racingCars = Cars.createCars(InputView.getRacingCars());
        Race race = Race.createRace(racingCars);
        OutputView.printTryMessage();
        int tryNumber = InputView.getTryNumber();
        OutputView.printShowResultString();
        for (int i = 0; i < tryNumber; i++) {
            race.run();
            System.out.println();
        }

        System.out.println(getWinnerString(race.getWinners()));
    }

    private static String getWinnerString(List<Car> winners) {
        StringBuilder sb= new StringBuilder();
        sb.append("최종 우승자 : ");
        for (Car car:winners) {
            sb.append(car.getName());
        }
        return sb.toString();
    }
}