package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_TOTAL_RACE_MESSAGE = "시도할 회수는 몇회인가요?";

    private Input() {
    }

    public static List<String> getCarNames() {
        String userInput = readLineWithPrompt(GET_CAR_NAMES_MESSAGE);
        return parseCarNames(userInput);
    }

    public static int getTotalRace() {
        String userInput = readLineWithPrompt(GET_TOTAL_RACE_MESSAGE);
        return tryParseTotalRace(userInput);
    }

    private static List<String> parseCarNames(String input) {
        List<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            carNames.add(name.trim());
        }
        return carNames;
    }

    private static Integer tryParseTotalRace(String userInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine();
    }
}
