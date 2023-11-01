package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Take part in I/O jobs
 *
 * @author WorldBestProgrammer
 */
public class RaceGameUserInterfaceView {

    /**
     * Displays when getting car names input
     */
    public static void displayUserCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    /**
     * Displays when getting total round input
     */
    public static void displayTotalRoundInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    /**
     * Gets input
     * @return Input value
     */
    public static String getInput() {
        return readLine();
    }

    /**
     * Displays '실행 결과' when starting race game
     */
    public static void displayRaceGameStartMessage() {
        System.out.println("\n실행 결과");
    }

    /**
     * Displays distance per car name
     *
     * @param userCarDistance key, value a pair of (car name, distance)
     */
    public static void displayUserCarDistance(LinkedHashMap<String, Integer> userCarDistance) {
        for (String userCar : userCarDistance.keySet()) {
            Integer distance = userCarDistance.get(userCar);

            System.out.println(userCar + " : " + "-".repeat(distance));
        }
        System.out.println();
    }

    /**
     * Displays the winners of the race game
     *
     * @param winners List of winners' name
     */
    public static void displayWinner(List<String> winners) {

        System.out.print("최종 우승자 : ");
        System.out.print(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            String winner = winners.get(i);
            System.out.print(", " + winner);
        }
    }
}
