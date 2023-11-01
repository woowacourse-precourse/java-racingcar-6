package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayingGame {
    private static final int MOVE_THRESHOLD = 4;
    private List<Car> cars = new ArrayList<>();

    public PlayingGame(String names) {
        for (String name : separateCarName(names)) {
            cars.add(new Car(name.trim()));
        }
    }

    private String[] separateCarName(String names) {
        return names.split(",");
    }

    public void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}