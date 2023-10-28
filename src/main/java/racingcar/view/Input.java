package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private Input() {
    }

    public static List<String> getCarNames() {
        String userInput = readLineWithPrompt(GET_CAR_NAMES_MESSAGE);
        return parseCarNames(userInput);
    }

    private static List<String> parseCarNames(String input) {
        List<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            carNames.add(name.trim());
        }
        return carNames;
    }

    private static String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine();
    }
}
