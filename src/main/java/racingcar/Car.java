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

    void runRace (int repeatNumber) {
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

    private boolean canMove() { //0~9까지 무작위 값을 구해 4 이상일 경우 전진하는 기능
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber > 3;
    }
    private void increaseCarPosition(String name) {
        if (canMove()) {
            this.racingLineup.put(name, this.racingLineup.get(name) + 1);
        }
    }

    private void printRaceResult(String name) { //출력 부분 -> Application 클래스로 옮기기
        System.out.printf("%s : ",name);
        for (int i=0; i<this.racingLineup.get(name); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    ArrayList<String> makeWinnerList() { //게임 완료 후 우승자 판단 및 명단 제작
        int maxPosition = Collections.max(this.racingLineup.values());
        for (String carName : this.racingLineup.keySet()) {
            this.winnerList.add(findNameByPosition(carName, maxPosition));
        }
        winnerList.removeAll(Collections.singletonList(null));

        return this.winnerList;
    }
    private String findNameByPosition(String carName, Integer position) { //우승자 판단 내부 로직
        if(racingLineup.get(carName).equals(position)) {
            return carName;
        }
        return null;
    }
}
