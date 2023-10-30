package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private List<Car> carList;
    private RacingSetting racingSetting;

    void start() {
        racingSetting = new RacingSetting();
        carList = new ArrayList<Car>();
        String[] name = racingSetting.getName();
        for (String currentName: name) {
            carList.add(new Car(currentName));
        }
        racingSetting.getMoveNum();
        System.out.println("\n실행 결과");
        int currentMoveNum = 0;
        while (racingSetting.isInRange(currentMoveNum++)) {
            for (Car currentCar: carList) {
                currentCar.move(Randoms.pickNumberInRange(0,9));
            }
            printMovingResult();
            System.out.println();
        }
        printWinner();
    }

    private void printMovingResult() {
        for (Car currentCar: carList) {
            currentCar.printInformation();
        }
    }

    private void printWinner() {
        Map<Integer, List<String>> scoreBoard = new HashMap<>();
        addscoreBoard(scoreBoard, carList);
        int maxScore = Collections.max(scoreBoard.keySet());
        List<String> winnerNames = scoreBoard.get(maxScore);
        System.out.print("최종 우승자 : ");
        for (String currnetName: winnerNames) {
            System.out.print(currnetName);
            if (!currnetName.equals(winnerNames.get(winnerNames.size() - 1))) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void addscoreBoard(Map<Integer, List<String>> scoreBoard, List<Car> carList) {
        for (Car currentCar: carList) {
            scoreBoard.computeIfAbsent(currentCar.getDestination(), k -> new ArrayList<>()).add(currentCar.getName());
        }
    }
}
