package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Round round = new Round();
        List<Car> racingCars = new ArrayList<>();
        Game carRace = new Game(round, racingCars);
        carRace.run();
    }
}
