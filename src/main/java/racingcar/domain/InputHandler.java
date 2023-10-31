package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    final String NAME_INPUT_TEXT =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String TRIAL_INPUT_TEXT = "시도할 회수는 몇회인가요?";

    public List<String> nameToList(String namesString) {
        return List.of(namesString.split(","));
    }

    public String inputName() {
        System.out.println(NAME_INPUT_TEXT);
        String input = Console.readLine();

        Exceptions.validateNameInput(input);

        return input;
    }

    public int trialToInt(String trial) {
        return Integer.parseInt(trial);
    }

    public String inputTrial() {
        System.out.println(TRIAL_INPUT_TEXT);
        String trial = Console.readLine();

        Exceptions.validateTrialInput(trial);

        return trial;
    }

    public LinkedHashMap<String, Integer> generateScoreboard(List<String> names) {
        LinkedHashMap<String, Integer> scoreboard = new LinkedHashMap<>();
        for (String name : names) {
            scoreboard.put(name, 0);
        }
        return scoreboard;
    }
}
