package racingcar.domain;

import java.util.List;

public class GameManager {
    static List<Car> carRace;
    static List<String> winner;

    public GameManager() {
        InputValue inputValue = new InputValue();
        playGame();
    }

    private void playGame() {
        makeCars(InputValue.carName);
    }

    private void makeCars(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Car car = new Car(list.get(i));
            carRace.add(car);
        }
    }
}
