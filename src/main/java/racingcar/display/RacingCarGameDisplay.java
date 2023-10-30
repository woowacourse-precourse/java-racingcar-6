package racingcar.display;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class RacingCarGameDisplay {
    private static final String PROMPT_RACING_CAR_GAME_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_CAR_GAME_WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String RACING_CAR_GAME_RESULT_MESSAGE = "실행 결과";
    private static final String PROMPT_RACING_CAR_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ", ";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";
    private static final int COMMA_LENGTH = 2;

    private RacingCarGameDisplay() {
    }

    public static void printGameStartMessage() {
        System.out.println(PROMPT_RACING_CAR_GAME_CARS_NAME_MESSAGE);
    }

    public static void printGameResultMessage() {
        System.out.println(NEW_LINE + RACING_CAR_GAME_RESULT_MESSAGE);
    }

    public static void printGameCountMessage() {
        System.out.println(PROMPT_RACING_CAR_GAME_COUNT_MESSAGE);
    }

    public static void printCarMovementResultMessage(Map<String, String> carMovementMap) {
        TreeSet<String> carNames = new TreeSet<>(carMovementMap.keySet());
        StringBuilder carMovementResult = new StringBuilder();

        for (String carName : carNames) {
            String distanceGraphics = carMovementMap.get(carName);
            carMovementResult.append(carName).append(COLON).append(distanceGraphics).append(NEW_LINE);
        }

        System.out.println(carMovementResult);
    }

    public static void printFinalWinnerNames(List<String> winnerNames) {
        List<String> winnerNameList = new ArrayList<>(winnerNames);
        Collections.sort(winnerNameList);

        StringBuilder finalWinnerNames = new StringBuilder();
        winnerNameList.forEach(name -> finalWinnerNames.append(name).append(COMMA));

        if (finalWinnerNames.length() > COMMA_LENGTH) {
            finalWinnerNames.setLength(finalWinnerNames.length() - COMMA_LENGTH);
        }

        System.out.print(RACING_CAR_GAME_WINNERS_MESSAGE + finalWinnerNames);
    }
}
