package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Entry;
import racingcar.model.Name;
import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.view.RaceView;

public class RaceController {

    public static void run() {
        Entry entry = new Entry();
        RaceView.getCarNames()
                .forEach(s -> {
                    Name name = new Name(s);
                    Car car = new Car(name);
                    entry.join(car);
                });
        Round totalRound = new Round(RaceView.getTotalRound());
        Race race = new Race(totalRound, entry);

        while (!race.isFinished()) {
            race.next();
            RaceView.printCurrentState(race);
        }
    }
}
