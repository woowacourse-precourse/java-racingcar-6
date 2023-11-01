package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Output {
    static String lineSeparator = System.lineSeparator();
    static final String CAR_NAME_INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String TRY_NUMBER_INPUT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    static final String RESULT_TITLE = lineSeparator + "실행 결과";
    static final String WINNERS = "최종 우승자 : ";

    static void printCarNameInputRequest() {
        System.out.println(CAR_NAME_INPUT_REQUEST_MESSAGE);
    }

    static void printTryNumberInputRequest() {
        System.out.println(TRY_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    static void printRacingMap(LinkedHashMap<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            System.out.println(carName+" : "+"-".repeat(cars.get(carName)));
        }
        System.out.println();
    }

    static boolean is_last(String winner, ArrayList<String> winners) {
        return winner.equals(winners.get(winners.size() - 1));
    }

    static void printWinners(ArrayList<String> winners) {
        System.out.print(WINNERS);
        for (String winner : winners) {
            if (is_last(winner, winners)) {
                System.out.println(winner);
                continue;
            }
            System.out.print(winner+", ");
        }
    }
}
