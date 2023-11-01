package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.Cars;
import racingcar.view.Finish;
import racingcar.view.ScorePrint;
import racingcar.view.Try;

public class RaceMap {
    public RaceMap() {
        List<String> cars = Cars.name();
        int maxTry = Try.input();
        int car_numbers = cars.size();
        int carLocation[] = new int[car_numbers];

        int tryCount = 0;

        while (tryCount < maxTry) {
            carLocation = Race.racing(carLocation, car_numbers);
            ScorePrint.resultByOrder(carLocation, cars);
            tryCount++;
        }
        Finish.victoryCars(carLocation, cars);
    }

}
