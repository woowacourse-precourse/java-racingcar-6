package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCar {
    public List<String> carName = new ArrayList<>();
    public List<Integer> movementSoFar = new ArrayList<>();
    Integer numberOfTries;

    public void changeLine() {
        System.out.println();
    }

    public void startPrintResult() {
        System.out.printf("%n실행결과%n");
    }

    public void carName() {
        carName = InputView.getCarName("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void setMovement() {
        for (int i = 0; i < carName.size(); i++) {
            movementSoFar.add(0);
        }
    }

    public void numberOfTries() {
        numberOfTries = InputView.getNumberOfTries("시도할 회수는 몇회인가요?");
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean move() {
        return generateRandomNumber() >= 4;
    }

    public void updateMovement(Integer indexOfCarName) {
        if (move()) {
            movementSoFar.set(indexOfCarName, (movementSoFar.get(indexOfCarName) + 1));
        }
    }

    public String getDash(Integer indexOfCarName) {
        return "-".repeat(Math.max(0, movementSoFar.get(indexOfCarName)));
    }

    public String printMovement(Integer indexOfCarName, List<String> carNameList) {
        updateMovement(indexOfCarName);
        return carNameList.get(indexOfCarName) + " : " + getDash(indexOfCarName);
    }

    public int longestMovement(List<Integer> movementSoFar) {
        return Collections.max(movementSoFar);
    }

    public List<Integer> howManyWinners(int longestMovement) {
        List<Integer> winnerIndexList = new ArrayList<>();
        for (int i = 0; i < movementSoFar.size(); i++) {
            if (movementSoFar.get(i) == longestMovement) {
                winnerIndexList.add(i);
            }
        }
        return winnerIndexList;
    }

    public String printWinner(List<Integer> winnerIndexList, List<String> carNameList) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerIndexList.size() - 1; i++) {
            result.append(carNameList.get(winnerIndexList.get(i))).append(", ");
        }
        result.append(carNameList.get(winnerIndexList.get(winnerIndexList.size() - 1)));
        return result.toString();
    }

    public String printFinalWinner(List<Integer> movementSoFar, List<String> carNameList) {
        int longestMovement = longestMovement(movementSoFar);
        List<Integer> winnerIndexList = howManyWinners(longestMovement);
        return printWinner(winnerIndexList, carNameList);
    }
}