package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRaceTrack;
import racingcar.domain.CarRacers;
import racingcar.domain.CarRacersRegisterFactory;
import racingcar.domain.RaceTrack;
import racingcar.domain.Racers;
import racingcar.view.ConsoleView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new ConsoleView();
        List<String> racersNames = view.requestRacerNames();
        Racers<Car> racers = CarRacersRegisterFactory.of(racersNames);
        RaceTrack<Car> raceTrack = new CarRaceTrack(racers);
        view.displayRaceResult();
        List<String> raceWinners = raceTrack.race(view.requestRaceNumberOfTime(), view::displayRaceStatus);
        view.displayWinner(raceWinners);
    }
}
