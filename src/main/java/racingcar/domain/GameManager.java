package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static int tryCount;

    public GameManager() {

    }

    private static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    private static void printGameTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    private static String readUserInput() {
        return Console.readLine();
    }

    public static boolean validateRacingcarName(String racingcarName) {
        if (racingcarName == null || racingcarName.isEmpty()) {
            throw new IllegalArgumentException("racingcar 이름이 null이거나 비어있습니다.");
        }
        if (racingcarName.length() > 5) {
            throw new IllegalArgumentException("racingcar 이름이 5자를 초과합니다.");
        }

        return true;
    }

    public static boolean validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("유저 입력값이 null이거나 비어있습니다.");
        }
        List<String> racingcarNames = List.of(userInput.split(","));
        // if there is the same racingcar name, throw exception
        if (racingcarNames.stream().distinct().count() != racingcarNames.size()) {
            throw new IllegalArgumentException("중복된 racingcar 이름이 있습니다.");
        }

        for (String racingcarName : racingcarNames) {
            validateRacingcarName(racingcarName);
        }
        return true;
    }

    public static boolean validateUserInputForTryCount(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("유저 입력값이 null이거나 비어있습니다.");
        }
        try {
            int tryCount = Integer.parseInt(userInput);
            if (tryCount < 1) {
                throw new IllegalArgumentException("유저 입력값이 1보다 작습니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유저 입력값이 정수가 아닙니다.");
        }

        return true;
    }

    public static void runGame() {

        printGameStartMessage();
        String userInput = readUserInput();
        validateUserInput(userInput);
        printGameTryCountMessage();
        userInput = readUserInput();
        validateUserInputForTryCount(userInput);

    }
}
