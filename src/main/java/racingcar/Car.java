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

    void moveCar() {
        Set<String> carNames = this.racingLineup.keySet();
        for (String name : carNames) {
            increaseCarPosition(name);
            printOutCarPosition(name);
        }
        System.out.println();
    }

    boolean checkCarMove() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber > 3;
    }

    void increaseCarPosition(String name) {
        if (checkCarMove()) {
            this.racingLineup.put(name, this.racingLineup.get(name) + 1);
        }
    }

    void printOutCarPosition(String name) {
        System.out.printf("%s : ",name);
        for (int i=0; i<this.racingLineup.get(name); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    ArrayList<String> whoIsWinner() {
        int maxPosition = Collections.max(this.racingLineup.values());
        for (String carName : this.racingLineup.keySet()) {
            this.winnerList.add(findCar(carName, maxPosition));
        }
        winnerList.removeAll(Collections.singletonList(null));

        return this.winnerList;
    }
    String findCar(String carName, Integer position) {
        if(racingLineup.get(carName).equals(position)) {
            return carName;
        }
        return null;
    }
}
