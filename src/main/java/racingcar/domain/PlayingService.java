package racingcar.domain;

import java.util.Map;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

public class PlayingService {
    private Car carsName;

    public void generateGame() {
        enterName();
    }

    private void enterName() {
        String[] name = Console.readLine().split(",");
        Map<String, Integer> playerAndScore = new HashMap<>();
        for (String s : name) {
            s = s.strip();
            playerAndScore.put(s, 0);
        }
        carsName = new Car(playerAndScore);
    }
}
