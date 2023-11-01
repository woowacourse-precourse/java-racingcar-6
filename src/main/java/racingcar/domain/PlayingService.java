package racingcar.domain;

import java.util.Map;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;

public class PlayingService {
    private final Number number;
    private RoundPlaying master = new RoundPlaying();
    Map<String, Integer> cars = new HashMap<>();

    public PlayingService() {
        String names = Console.readLine();
        enterName(names);

        String num = Console.readLine();
        number = new Number(num);

        for (int i = 0; i < number.number; i++) {
            cars = master.playRound(cars);
        }
    }

    void enterName(String names) {
        String[] name = names.split(",");
        for (String s : name) {
            s = s.strip();
            validateName(s);
            cars.put(s, 0);
        }
    }

    private void validateName(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘기면 안 됩니다!");
        }
    }
}
