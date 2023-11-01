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

    RacingGame() {
        racingSetting = new RacingSetting();
        carList = new ArrayList<Car>();
    }

    void start() {
        initializeGameSettings();
        startRace();
        printWinner(checkWinner(checkScore()));
    }

    private void initializeGameSettings() {
        String[] CarNames = racingSetting.getCarName();
        for (String currentName: CarNames) {
            carList.add(new Car(currentName));
        }
        racingSetting.getMoveNum();
    }

    private void startRace() {
        System.out.println("\n실행 결과");
        for (int currentMoveNum = 0; racingSetting.isInRange(currentMoveNum); currentMoveNum++) {
            moveCars();
            printMovingResult();
        }
    }

    private void moveCars() {
        for (Car currentCar: carList) {
            currentCar.move(isMoveSpeed());
        }
    }

    private int isMoveSpeed() {
        return (Randoms.pickNumberInRange(0,9));
    }

    private void printMovingResult() {
        for (Car currentCar: carList) {
            currentCar.printInformation();
        }
        System.out.println();
    }

    private Map<Integer, List<String>> checkScore() {
        Map<Integer, List<String>> scoreBoard = new HashMap<>();
        addScoreboard(scoreBoard, carList);
        return (scoreBoard);
    }

    private List<String> checkWinner(Map<Integer, List<String>> scoreboard) {
        int maxScore = Collections.max(scoreboard.keySet());

        return (scoreboard.get(maxScore));
    }

    private void printWinner(List<String> winnerNames) {

        System.out.print("최종 우승자 : ");
        for (String currentName: winnerNames) {
            System.out.print(currentName);
            if (!currentName.equals(winnerNames.get(winnerNames.size() - 1))) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void addScoreboard(Map<Integer, List<String>> scoreboard, List<Car> carList) {
        for (Car currentCar: carList) {
            scoreboard.computeIfAbsent(currentCar.getDestination(), k -> new ArrayList<>()).add(currentCar.getName());
        }
    }
}
