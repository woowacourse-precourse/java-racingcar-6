package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.util.CarUtil;
import racingcar.util.RaceUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private static Race race;

    public static void racingGame() {
        raceSet();
        raceStart();
        raceEnd();
    }
    private static void raceSet() {
        List<Car> car = CarUtil.createCar(InputView.requestCarName());
        race = new Race(car, RaceUtil.raceNumber(InputView.requestMoveTime()));
    }

    private static void raceStart() {
        OutputView.raceStart();
        for (int i = 0; i<race.getMoveTime(); i++) {
            RaceUtil.movePosition(race.getCars());
            OutputView.raceResult(race);
        }
    }

    private static void raceEnd() {
        OutputView.printWinner(RaceUtil.getWinner(race.getCars()));
    }


}
