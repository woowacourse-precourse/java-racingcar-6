package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Play {
    public static void start(){

        List<String> carNames = UserInput.inputCarName();
        int gameCount = UserInput.inputGameCount();

        goAhead(carNames, gameCount);

    }

    public static void goAhead(List<String> carNamesList, int gameCount) {

        Map<String, Integer> carPositions = initCarPositions(carNamesList);

        for (int i = 0; i < gameCount; i++) {
            moveCars(carPositions);
            printCarPositions(carPositions);
            System.out.println();
        }
        List<String> winners = getWinners(carPositions);
        printWinners(winners);

    }

    public static Map<String, Integer> initCarPositions(List<String> carNamesList) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNamesList) {
            carPositions.put(carName, 0);
        }
        return carPositions;
    }
    public static void moveCars(Map<String, Integer> carPositions) {
        for (String carName : carPositions.keySet()) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                carPositions.put(carName, carPositions.get(carName) + 1);
            }
        }
    }

    public static void printCarPositions(Map<String, Integer> carPositions) {
        for (String carName : carPositions.keySet()) {
            System.out.print(carName + " : ");
            for (int i = 0; i < carPositions.get(carName); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static List<String> getWinners(Map<String, Integer> carPositions) {
        int maxPosition = carPositions.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        return carPositions.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
