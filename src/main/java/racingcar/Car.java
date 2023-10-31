package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Car {

    private final HashMap<String, Integer> racingLineup;
    private final ArrayList<String> winnerList;

    Car(String[] names) {
        this.racingLineup = new HashMap<>();
        this.winnerList = new ArrayList<>();
        for (String name : names) {
            this.racingLineup.put(name, 0);
        }
    }

    void runRace(int repeatNumber) {
        for (int i = 0; i < repeatNumber; i++) {
            this.runRaceOnce();
        }
    }

    private void runRaceOnce() {
        Set<String> carNames = this.racingLineup.keySet();
        for (String name : carNames) {
            increaseCarPosition(name);
            printRaceResult(name);
        }
        System.out.println();
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private void increaseCarPosition(String name) {
        if (canMove()) {
            this.racingLineup.put(name, this.racingLineup.get(name) + 1);
        }
    }

    private void printRaceResult(String name) {
        System.out.printf("%s : ", name);
        for (int i = 0; i < this.racingLineup.get(name); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    ArrayList<String> makeWinnerList() {
        int maxPosition = Collections.max(this.racingLineup.values());
        for (String carName : this.racingLineup.keySet()) {
            this.winnerList.add(findNameByPosition(carName, maxPosition));
        }
        winnerList.removeAll(Collections.singletonList(null));

        return this.winnerList;
    }

    int getCarPosition(String carName) {
        return racingLineup.get(carName);
    }

    private String findNameByPosition(String carName, Integer position) {
        if (this.getCarPosition(carName) == position) {
            return carName;
        }
        return null;
    }
}
