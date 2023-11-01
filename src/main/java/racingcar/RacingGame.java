package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final List<Car> carList;
    private MoveNum moveNum;

    RacingGame() {
        carList = new ArrayList<>();
    }

    void start() {
        inputRacingCars();
        inputMoveNum();
        startRace();
        OutputPrinter.printWinner(checkWinner(checkScore()));
    }

    private void inputRacingCars() {
        OutputPrinter.printRacingCarsInputRequestMessage();
        RacingCars racingCars = new RacingCars(Util.getUserInput());
        initalizeCarList(racingCars.getCarName());
    }

    private void initalizeCarList(String [] carNames) {
        for (String currentName: carNames) {
            carList.add(new Car(currentName));
        }
    }

    private void inputMoveNum() {
        OutputPrinter.printMoveNumInputRequestMessage();
        moveNum = new MoveNum(Util.getUserInput());
    }

    private void startRace() {
        OutputPrinter.printMoveResultPrintMessage();
        for (int currentMoveNum = 0; moveNum.isInRange(currentMoveNum); currentMoveNum++) {
            moveCars();
            OutputPrinter.printMovingResult(carList);
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

    private Map<Integer, List<String>> checkScore() {
        Map<Integer, List<String>> scoreBoard = new HashMap<>();
        addScoreboard(scoreBoard);
        return (scoreBoard);
    }

    private List<String> checkWinner(Map<Integer, List<String>> scoreboard) {
        return (scoreboard.get(Collections.max(scoreboard.keySet())));
    }


    private void addScoreboard(Map<Integer, List<String>> scoreboard) {
        for (Car currentCar: carList) {
            scoreboard.computeIfAbsent(currentCar.getDestination(), k -> new ArrayList<>()).add(currentCar.getName());
        }
    }
}
