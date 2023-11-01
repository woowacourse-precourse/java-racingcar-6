package racingcar.domain;

import java.util.Map;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

public class PlayingService {
    private Car carsName;

    public void generateGame() {
        String names = Console.readLine();
        enterName(names);
    }

    void enterName(String names) {
        String[] name = names.split(",");
        Map<String, Integer> playerAndScore = new HashMap<>();
        for (String s : name) {
            s = s.strip();
            playerAndScore.put(s, 0);
        }
        carsName = new Car(playerAndScore);
    }
}
