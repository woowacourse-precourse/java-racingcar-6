package mytest;

import java.util.LinkedHashMap;
import racingmodel.CarRacingGame;
import racingmodel.GoOrNot;

public class MockCarRacingGame extends CarRacingGame {

    LinkedHashMap<String, StringBuilder> carName = null;
    public MockCarRacingGame(LinkedHashMap<String, StringBuilder> carName) {
        super(carName);
    }

    @Override
    public void changeGame() {
        this.carName = super.getCarName();
        carName.forEach((key, value) -> {
            if (GoOrNot.GO == GoOrNot.GO) {
                carName.put(key, value.append("-"));
            }
        });;
    }
}
