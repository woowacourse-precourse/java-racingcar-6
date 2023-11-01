package racingcar.domain;

import java.util.Map;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;

public class PlayingService {
    private final Number number;
    private RoundPlaying master = new RoundPlaying();
    Map<String, Integer> cars = new HashMap<>();

    private final String START_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_MSG = "시도할 회수는 몇회인가요?";

    public PlayingService() {
        System.out.println(START_MSG);
        String names = Console.readLine();
        enterName(names);

        System.out.println(NUMBER_MSG);
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
