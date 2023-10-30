package racingcar;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race();
        SetRace set = new SetRace();
        System.out.println(race.raceCar(set.createCar(),set.inputMovement()));
    }
}
