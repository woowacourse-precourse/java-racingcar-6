package racingcar.domain;

import java.util.LinkedHashMap;
import camp.nextstep.edu.missionutils.Console;

public class PlayingService {
    private final Number number;
    private RoundPlaying master = new RoundPlaying();
    LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();

    private final String START_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_MSG = "시도할 회수는 몇회인가요?";
    private final String ROUND_MSG = "실행 결과";

    public PlayingService() {
        System.out.println(START_MSG);
        String names = Console.readLine();
        enterName(names);

        System.out.println(NUMBER_MSG);
        String num = Console.readLine();
        number = new Number(num);

        System.out.println(ROUND_MSG);
        for (int i = 0; i < number.number; i++) {
            cars = master.playRound(cars);
            System.out.println();
        }
        findWinner();
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

    void findWinner() {
        int maxScore = 0;
        String winners = "";
        for (String name : cars.keySet()) {
            maxScore = Math.max(maxScore, cars.get(name));
        }
        for (String name : cars.keySet()) {
            if (cars.get(name) == maxScore) {
                winners += name;
                winners += ", ";
            }
        }
        winners = winners.substring(0, winners.length() - 2);
        System.out.print("최종 우승자 : " + winners);
    }
}